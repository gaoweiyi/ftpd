package com.inputabc.ftpd.service;

import javax.servlet.http.HttpSession;

import com.inputabc.ftpd.entity.FNodePage;
/**
 * 
 * @author gaoweiyi
 *
 */
public interface FNodeSearchService {
	public FNodePage search(String content, int page, int pageSize, Integer sortMethod, HttpSession session) throws Exception;
}
