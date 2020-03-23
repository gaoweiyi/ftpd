package com.inputabc.ftpd.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.inputabc.ftpd.entity.FNode;

public interface FNodeService {
	List<FNode> listFiles(String basePath,String mainPath,Integer sortMethod, HttpSession session);

	String getImageName(String ex);
	/**
	 * 常规排序（默认）
	 * @param list
	 * @return
	 */
	List<FNode> sort(List<FNode> fnodes,HttpSession session);
	/**
	 * 按名称排序
	 * @param fnodes
	 * @param session
	 * @return
	 */
	List<FNode> sortByName(List<FNode> fnodes, HttpSession session);
	/**
	 * 按修改日期排序
	 * @param fnodes
	 * @param session
	 * @return
	 */
	List<FNode> sortByModified(List<FNode> fnodes, HttpSession session);
	/**
	 * 按文件类型排序
	 * @param fnodes
	 * @param session
	 * @return
	 */
	List<FNode> sortByType(List<FNode> fnodes, HttpSession session);
	/**
	 * 按文件大小排序
	 * @param fnodes
	 * @param session
	 * @return
	 */
	List<FNode> sortBySize(List<FNode> fnodes, HttpSession session);
	


}

