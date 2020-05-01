package com.inputabc.ftpd.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import com.inputabc.ftpd.constant.C;
import com.inputabc.ftpd.entity.FNode;
import com.inputabc.ftpd.service.FNodeService;
import com.inputabc.ftpd.util.FNodeUtils;
/**
 * 
 * @author gaoweiyi
 *
 */
@Service
public class FNodeServiceImpl implements FNodeService {
	@Override
	public List<FNode> listFiles(String basePath, String mainPath,Integer sortMethod,HttpSession session) {
		String dateFormat = (String) C.configCache.get("dateFormat").getObjectValue();
		List<FNode> fnodes = new ArrayList<FNode>();
		File[] listFiles = new File(basePath.replace("\\", "/"),mainPath.replace("\\","/")).listFiles();
		try {
			for (File file : listFiles) {
				fnodes.add(FNodeUtils.pack(basePath, file,dateFormat,null));
			}
		} catch (NullPointerException e) {
		}
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
		
		return fnodes;
	}
	
	
}
