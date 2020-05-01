package com.inputabc.ftpd.entity;
/**
 * 搜索的信息对象
 * @author gaoweiyi
 *
 */
public class SearchEntity {
	private String content;//搜索的内容（用户输入的内容）
	private int page;//页码
	
	public SearchEntity() {
	}
	public SearchEntity(String content, int page) {
		this.content = content;
		this.page = page;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
}
