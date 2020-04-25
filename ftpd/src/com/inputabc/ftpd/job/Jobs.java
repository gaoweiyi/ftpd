package com.inputabc.ftpd.job;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Component;
import org.wltea.analyzer.lucene.IKAnalyzer;
import com.inputabc.ftpd.constant.C;
import com.inputabc.ftpd.util.LuceneUtils;
import com.inputabc.ftpd.web.listener.AppInitializer;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
/**
 * 
 * @author gaoweiyi
 *
 */
@Component("jobs")
public class Jobs {
	private String extDicFileName;
	private FSDirectory directory;

	public Jobs() {
		this.initConfigJob();
		String file = this.getClass().getResource("/ext.dic").getFile();
		try {
			extDicFileName = URLDecoder.decode(file, "utf-8");
			directory = FSDirectory
					.open(Paths.get((String) C.configCache.get("indexPath").getObjectValue()));
			C.appCache.put(new Element("directory", directory));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void initConfigJob() {
		Properties p = new Properties();
		try {
			p.load(new InputStreamReader(Jobs.class.getResourceAsStream("/config/config.properties"), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String basePath = p.getProperty("basePath");
		if (StringUtils.isBlank(basePath)) {
			throw new RuntimeException("未指定一个默认的列表目录，请修改你的basePath参数！");
		}else{
			basePath = basePath.replace("\\", "/");
		}
		String showDirSize = p.getProperty("showDirSize");
		if (StringUtils.isBlank(showDirSize)) {
			showDirSize = "false";
		}
		String autoMimeType = p.getProperty("autoMimeType");
		if (StringUtils.isBlank(autoMimeType)) {
			autoMimeType = "false";
		}
		String indexPath = p.getProperty("indexPath");
		if (StringUtils.isBlank(indexPath)) {
			indexPath = System.getProperty("java.io.tmpdir") + "/ftpd/index/";
		} else if (indexPath.startsWith("java.io.tmpdir")) {
			String subPath = indexPath.substring("java.io.tmpdir".length());
			indexPath = System.getProperty("java.io.tmpdir") + subPath;
		}
		String dateFormat = p.getProperty("dateFormat");
		if (StringUtils.isBlank(dateFormat)) {
			dateFormat = "yyyy/MM/dd HH:mm";
		}
		Cache configcache = C.configCache;
		if (configcache == null) {
			new AppInitializer().contextInitialized(null);
		}
		configcache.put(new Element("basePath", basePath));
		configcache.put(new Element("showDirSize", showDirSize));
		configcache.put(new Element("autoMimeType", autoMimeType));
		configcache.put(new Element("indexPath", indexPath));
		configcache.put(new Element("dateFormat", dateFormat));
	}

	/**
	 * <p>
	 * 将basePath所在目录下的文件及文件夹建索引到索引库。<br>
	 * 每30分钟触发一次（如果你的机器性能比较好，可以在quartz配置文件中将时间间隔改小一点）；触发时首先删除索引库。<br>
	 * 文档结构：<br>
	 * <p>
	 * filename:文件名<br>
	 * ex:文件扩展名<br>
	 * path:文件全路径<br>
	 * </p>
	 * 注意：path域仅存储，不进行索引。将来使用path域对应的文件路径来生成FNode对象。
	 * </p>
	 * 
	 * @throws IOException
	 */
	public void searchIndexJob() throws IOException {

		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new IKAnalyzer());
		IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
		try {
			LuceneUtils.deleteIndex(indexWriter);
			System.err.println("成功删除索引库");
			LuceneUtils.clearExtDic(extDicFileName);
			System.err.println("成功清空扩展字典");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(extDicFileName)));

		String basePath = (String) C.configCache.get("basePath").getObjectValue();
		System.err.println(basePath);
		if (StringUtils.isNotBlank(basePath)) {
			System.err.println("开始重建索引");
			// 建索引
			Files.walkFileTree(Paths.get(basePath), new FileVisitor<Path>() {
				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
					try {
						LuceneUtils.addDocument(dir, indexWriter, bw);
					} catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					}
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					try {
						LuceneUtils.addDocument(file, indexWriter, bw);
					} catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					}
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					return FileVisitResult.CONTINUE;
				}

			});
		}
		bw.close();
		indexWriter.close();
		System.err.println("重建索引成功");
	}



	public static void main(String[] args) throws IOException, ParseException {
		// long s = System.currentTimeMillis();
		// CacheManager cm = null;
		// try {
		// cm =
		// CacheManager.create(C.class.getResourceAsStream("/config/ehcache.xml"));
		// } catch (CacheException ce) {
		// ce.printStackTrace();
		// }
		// C.configCache = cm.getCache("config");
		// Jobs jobs = new Jobs();
		// jobs.initConfigJob();
		// jobs.searchIndexJob();
		// long e = System.currentTimeMillis();
		// System.out.println((e-s)/1000+"s");

		long s = System.currentTimeMillis();
		Jobs jobs = new Jobs();
		DirectoryReader reader = DirectoryReader.open(jobs.directory);
		IndexSearcher searcher = new IndexSearcher(reader);
		// 查询第一页数据
		int currentPage = 1;
		int pageSize = 50;
		int n = (currentPage - 1) * pageSize;
		ScoreDoc sd = null;
		IKAnalyzer ikAnalyzer = new IKAnalyzer();
		QueryParser queryParser = new QueryParser("ex", ikAnalyzer);
		Query query = queryParser.parse("iso OR filename:iso");
		if (currentPage > 1) {
			TopDocs td = searcher.search(query, n);
			sd = td.scoreDocs[n - 1];
		}
		TopDocs td = searcher.searchAfter(sd, query, pageSize);
		ScoreDoc[] scoreDocs = td.scoreDocs;
		System.out.println("总记录数：" + td.totalHits);
		for (int x = 0; x < td.scoreDocs.length; x++) {
			Document doc = searcher.doc(scoreDocs[x].doc);
			String path = doc.get("path");
			System.out.println(path);
		}
		reader.close();
		long e = System.currentTimeMillis();
		System.out.println((e - s) / 1000 + "s");
	}
}
