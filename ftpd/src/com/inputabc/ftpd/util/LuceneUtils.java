package com.inputabc.ftpd.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;

import org.apache.commons.io.FilenameUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexWriter;
/**
 * 
 * @author gaoweiyi
 *
 */
public class LuceneUtils {
	private LuceneUtils() {
	}

	/**
	 * 删除索引库
	 * 
	 * @param indexWriter
	 * @throws IOException
	 */
	public static void deleteIndex(IndexWriter indexWriter) throws Exception {
		indexWriter.deleteAll();
		indexWriter.commit();
	}

	/**
	 * 清空扩展字典ext.dic的内容
	 * @param extDicFileName
	 * @throws Exception
	 */
	public static void clearExtDic(String extDicFileName) throws Exception {
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(extDicFileName));
		osw.write("");
		osw.close();
	}
	/**
	 * 将一个文件（文件夹）的信息封装成文档并写入索引库
	 * 
	 * @param fileOrDir
	 * @param indexWriter
	 * @param bw
	 * @throws Exception
	 */
	public static void addDocument(Path fileOrDir,IndexWriter indexWriter, BufferedWriter bw) throws Exception {
		String filename = fileOrDir.toFile().getName();
		String ex = FilenameUtils.getExtension(filename);
		String path = fileOrDir.toFile().getAbsolutePath();
		String noExFilename = PFileUtils.getMainName(filename, ex);
		bw.write(noExFilename);// 写入一个文件名到扩展字典ext.dic，将来可以根据这个文件名搜索到这个文件
		bw.newLine();
		bw.write(ex);// 写入一个文件扩展名到扩展字典ext.dic，将来可以根据这个扩展名搜索到这个文件
		bw.newLine();
		bw.flush();
		
		Document doc = new Document();
		doc.add(new TextField("filename", filename, Store.YES));
		doc.add(new StringField("ex", ex, Store.NO));
		doc.add(new StoredField("path", path));
		indexWriter.addDocument(doc);
	}
}
