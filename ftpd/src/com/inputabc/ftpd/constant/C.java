package com.inputabc.ftpd.constant;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
/**
 * 常量集
 * @author 高伟益
 *
 */
public class C {
	//public static final ConcurrentHashMap<String,Object> configs = new ConcurrentHashMap<String,Object>();
	public static Cache configCache;
	public static final String line = System.getProperty("line.separator");
}

