package com.inputabc.ftpd.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.inputabc.ftpd.entity.FNode;
/**
 * 
 * @author gaoweiyi
 *
 */
public interface FNodeService {
	List<FNode> listFiles(String basePath,String mainPath,Integer sortMethod, HttpSession session);
}

