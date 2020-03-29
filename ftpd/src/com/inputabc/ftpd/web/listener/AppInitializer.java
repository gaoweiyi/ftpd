package com.inputabc.ftpd.web.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


import com.inputabc.ftpd.constant.C;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;

/**
 * 应用启动时做的事情
 * 
 * @author gaoweiyi
 *
 */
public class AppInitializer implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {}

	@Override
	public void contextInitialized(ServletContextEvent e) {
		initCache();
	}

	/**
	 * 初始化ehcache缓存
	 */
	private void initCache() {
		CacheManager cm = null;
		try {
			cm = CacheManager.create(C.class.getResourceAsStream("/config/ehcache.xml"));
		} catch (CacheException ce) {
			ce.printStackTrace();
		}
		C.configCache = cm.getCache("config");
	}
}
