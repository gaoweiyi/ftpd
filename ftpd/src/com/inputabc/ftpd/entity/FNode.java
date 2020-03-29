package com.inputabc.ftpd.entity;

import java.io.Serializable;
/**
 * 文件节点对象
 * @author 高伟益
 *
 */
public class FNode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4952449375517673271L;
	private String id;
	private String mainPath;//文件的主要路径，基于basePath而言
	private String name;//文件名
	private Long size;//文件大小
	private String modified;//文件的修改日期
	private String ex;//文件扩展名
	private String imageName;//文件图片的文件名
	private String displaySize;//字符串形式的文件大小
	private Integer type;//0表示文件 1表示目录
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMainPath() {
		return mainPath;
	}
	public void setMainPath(String mainPath) {
		this.mainPath = mainPath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public String getEx() {
		return ex;
	}
	public void setEx(String ex) {
		this.ex = ex;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getDisplaySize() {
		return displaySize;
	}
	public void setDisplaySize(String displaySize) {
		this.displaySize = displaySize;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
}

