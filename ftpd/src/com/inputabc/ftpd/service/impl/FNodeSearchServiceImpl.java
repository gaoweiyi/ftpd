package com.inputabc.ftpd.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inputabc.ftpd.dao.FNodeSearchDao;
import com.inputabc.ftpd.entity.FNode;
import com.inputabc.ftpd.entity.FNodePage;
import com.inputabc.ftpd.service.FNodeSearchService;
import com.inputabc.ftpd.util.FNodeUtils;
/**
 * 
 * @author gaoweiyi
 *
 */
@Service
public class FNodeSearchServiceImpl implements FNodeSearchService {
	@Autowired
	private FNodeSearchDao fnsd;

	@Override
	public FNodePage search(String content, int page, int pageSize, Integer sortMethod, HttpSession session)
			throws Exception {
		FNodePage fNodePage = fnsd.search(content, page, pageSize);
		List<FNode> fnodes = fNodePage.getData();
		System.out.println(page);
		System.out.println(pageSize);
//		int ideal = 0;// 理想结果数
//		for (FNode fnode : fnodes) {
//			if (fnode.getName().contains(content)) {
//				ideal++;
//			}
//		}
//		if (ideal == 0) {
//			//判断ext2.dic里有没有和用户搜索的内容一样的关键字
//			//如果有，就不要添加到ext2.dic
//			//如果没有，就添加
//			boolean needAddToExt2 = true;
//			BufferedReader br = new BufferedReader(
//					new InputStreamReader(this.getClass().getResourceAsStream("/ext2.dic"), "utf-8"));
//			for (String line = null; (line = br.readLine()) != null;) {
//				if (line.trim().equals(content)) {
//					needAddToExt2 = false;
//					break;
//				}
//			}
//			br.close();
//			if (needAddToExt2 && StringUtils.isNotBlank(content) && content.length()>1) {
//				// 可能有对应的文件，但没有搜索到
//				// 将用户输入的搜索内容追加到ext2.dic，方便下次能够搜索到（重建索引后）
//				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
//						new FileOutputStream(
//								URLDecoder.decode(this.getClass().getResource("/ext2.dic").getFile(), "utf-8"),true),
//						"utf-8"));
//				bw.newLine();
//				bw.write(content);
//				bw.flush();
//				bw.close();
//			}
//		}
		if(sortMethod==1){
			//按名称排序
			fnodes = FNodeUtils.sortByName(fnodes,session);
		}else if(sortMethod==2){
			//按修改日期排序
			fnodes = FNodeUtils.sortByModified(fnodes,session);
		}else if(sortMethod==3){
			//按类型排序
			fnodes = FNodeUtils.sortByType(fnodes,session);
		}else if(sortMethod==4){
			//按大小排序
			fnodes = FNodeUtils.sortBySize(fnodes,session);
		}else{
			fnodes = FNodeUtils.sort(fnodes,session);
		}
		fNodePage.setData(fnodes);
		return fNodePage;
	}

}
