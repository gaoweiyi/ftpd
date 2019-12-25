package com.inputabc.ftpd.constant;

import java.util.concurrent.ConcurrentHashMap;
/**
 * 常量集
 * @author 高伟益
 *
 */
public class C {
	public static final ConcurrentHashMap<String,Object> configs = new ConcurrentHashMap<String,Object>();
	public static final String line = System.getProperty("line.separator");
}
