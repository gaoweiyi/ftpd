package com.inputabc.ftpd.dao;

import com.inputabc.ftpd.entity.FNodePage;
/**
 * 
 * @author gaoweiyi
 *
 */
public interface FNodeSearchDao {
	public FNodePage search(String content, int page,int pageSize) throws Exception;
}
