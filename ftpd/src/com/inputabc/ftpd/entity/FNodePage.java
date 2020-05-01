package com.inputabc.ftpd.entity;

import java.util.List;
/**
 * 分页查询结果对象
 * @author gaoweiyi
 *
 */
public class FNodePage {
	private List<FNode> data;//当前页的FNode对象集合
	private Long totalCount;//总文件数（总结果数）
	
	public FNodePage() {
	}

	public FNodePage(List<FNode> data, Long totalCount) {
		super();
		this.data = data;
		this.totalCount = totalCount;
	}

	public List<FNode> getData() {
		return data;
	}

	public void setData(List<FNode> data) {
		this.data = data;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

}
