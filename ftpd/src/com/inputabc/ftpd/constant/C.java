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
	public static final Cache configCache;
	public static final String line = System.getProperty("line.separator");
	static{
		CacheManager cm = null;
		try {
			cm = CacheManager.create(C.class.getResourceAsStream("/config/ehcache.xml"));
		} catch (CacheException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		configCache = cm.getCache("config");
	}
}

