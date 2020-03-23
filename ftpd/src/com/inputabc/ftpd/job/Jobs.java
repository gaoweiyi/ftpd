package com.inputabc.ftpd.job;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.inputabc.ftpd.constant.C;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

@Component("jobs")
public class Jobs {
	public void initConfigJob() {
		Properties p = new Properties();
		try {
			p.load(new InputStreamReader(Jobs.class.getResourceAsStream("/config/config.properties"),
					"UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String basePath = p.getProperty("basePath");
		if (StringUtils.isBlank(basePath)) {
			throw new RuntimeException("未指定一个默认的列表目录，请修改你的basePath参数！");
		}
		String showDirSize = p.getProperty("showDirSize");
		if (StringUtils.isBlank(showDirSize)) {
			showDirSize = "false";
		}
		String autoMimeType = p.getProperty("autoMimeType");
		if (StringUtils.isBlank(autoMimeType)) {
			autoMimeType = "false";
		}
//		C.configs.put("basePath", basePath);
//		C.configs.put("showDirSize", showDirSize);
//		C.configs.put("autoMimeType", autoMimeType);
		Cache configcache = C.configCache;
		configcache.put(new Element("basePath", basePath));
		configcache.put(new Element("showDirSize", showDirSize));
		configcache.put(new Element("autoMimeType", autoMimeType));
		
	}

}

