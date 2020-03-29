package com.inputabc.ftpd.util;

import java.io.File;
import java.io.Writer;

import freemarker.template.Configuration;
import freemarker.template.Template;
/**
 * Freemarker工具类
 * @author gaoweiyi
 * @version 1.0
 * @date 2020/3/27 18:15
 *
 */
public class FreemarkerUtils {
	private FreemarkerUtils(){}
	private static Configuration config = new Configuration(Configuration.getVersion());
	public static void process(String targetDir,String templateFileName,Object model,Writer writer){
		try {
			config.setDirectoryForTemplateLoading(new File(targetDir));
			config.setDefaultEncoding("utf-8");
			Template template = config.getTemplate(templateFileName);
			template.process(model, writer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
