package com.inputabc.ftpd.dao.impl;

import java.io.File;
import java.io.StringReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Repository;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.inputabc.ftpd.constant.C;
import com.inputabc.ftpd.dao.FNodeSearchDao;
import com.inputabc.ftpd.entity.FNode;
import com.inputabc.ftpd.entity.FNodePage;
import com.inputabc.ftpd.util.FNodeUtils;
/**
 * 
 * @author gaoweiyi
 *
 */
@Repository
public class FNodeSearchDaoImpl implements FNodeSearchDao {

	@Override
	public FNodePage search(String content, int page, int pageSize) throws Exception {
		String indexPath = (String) C.configCache.get("indexPath").getObjectValue();
		FSDirectory directory = FSDirectory.open(Paths.get(indexPath, ""));
		DirectoryReader reader = DirectoryReader.open(directory);
		IndexSearcher searcher = new IndexSearcher(reader);
		int start = (page - 1) * pageSize;
		ScoreDoc sd = null;
		IKAnalyzer ikAnalyzer = new IKAnalyzer();
		QueryParser queryParser = new QueryParser("ex", ikAnalyzer);
		Query query = queryParser.parse(content + "* OR filename:"+ content+"* OR ex:"+content+" OR filename:"+content);
		if (page > 1) {
			TopDocs td = searcher.search(query, start,Sort.INDEXORDER);// 查一遍
			if(start>td.totalHits){//如果当前页的页码大于最大查询页码，例如总页码为2页，当前页为第3页
				return new FNodePage(new ArrayList<>(), td.totalHits);//返回空结果集
			}
			sd = td.scoreDocs[start - 1];
		}
		
		TopDocs td = searcher.searchAfter(sd, query, pageSize,Sort.INDEXORDER);// 再查一遍
		boolean enableHighlight = Boolean.parseBoolean((String)C.configCache.get("enableHighlight").getObjectValue());
		Highlighter highlighter = null;
		if(enableHighlight){
			//开启高亮支持
			QueryScorer queryScorer = new QueryScorer(query);
			SimpleSpanFragmenter simpleSpanFragmenter = new SimpleSpanFragmenter(queryScorer);
			String highlightColor = (String) C.configCache.get("highlightColor").getObjectValue();
			SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<span style='color:"+highlightColor+"'>", "</span>");
			highlighter=new Highlighter(simpleHTMLFormatter, queryScorer);  
            highlighter.setTextFragmenter(simpleSpanFragmenter); 
		}
		ScoreDoc[] scoreDocs = td.scoreDocs;
		List<FNode> fnodes = new ArrayList<>();
		String basePath = (String) C.configCache.get("basePath").getObjectValue();
		String dateFormat = (String) C.configCache.get("dateFormat").getObjectValue();
		for (int x = 0; x < td.scoreDocs.length; x++) {
			Document doc = searcher.doc(scoreDocs[x].doc);
			String path = doc.get("path");
			String filename = doc.get("filename");
			if(highlighter!=null){
				TokenStream tokenStream = ikAnalyzer.tokenStream("filename", new StringReader(filename));
				filename = highlighter.getBestFragment(tokenStream,filename);
			}
			File file = new File(path);
			FNode fnode = FNodeUtils.pack(basePath, file, dateFormat,filename);
			fnodes.add(fnode);
		}
		
		long totalHits = td.totalHits;// 总结果数
		reader.close();
		return new FNodePage(fnodes, totalHits);
	}

}
