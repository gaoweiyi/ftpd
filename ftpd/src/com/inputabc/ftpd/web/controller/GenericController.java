package com.inputabc.ftpd.web.controller;

import java.io.BufferedOutputStream;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inputabc.ftpd.constant.C;
import com.inputabc.ftpd.util.PFileUtils;
/**
 * 
 * @author gaoweiyi
 *
 */
@Controller
@RequestMapping("genericController.do")
public class GenericController {

	@RequestMapping(params = "smartFix")
	/**
	 * 自动修复异常
	 * @param request
	 * @param response
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void smartFix(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, IOException{
		fixConfig();
		String scheme = request.getScheme();
		String hostName = request.getServerName();
		int port = request.getServerPort();
		String projectName = request.getServletContext().getContextPath();
		String url = scheme+"://"+hostName+":"+port+projectName;
		response.sendRedirect(url);
	}
	@RequestMapping(params = "init")
	public void init(HttpServletRequest request,HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3600*24*7);
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setPath("/");
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		session.setAttribute("sortByNameFlag", false);
		session.setAttribute("sortByModifiedFlag", false);
		session.setAttribute("sortByTypeFlag", false);
		session.setAttribute("sortBySizeFlag", false);
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache"); 
		response.setDateHeader("Expires", 0);
		response.addCookie(cookie);
		response.sendRedirect("fnodeController.do?openDir&path=/");
	}
	private void fixConfig() throws FileNotFoundException, IOException{
		Properties p = new Properties();
		File configFile = null;
		try {
			URL configFileUrl = Thread.currentThread().getContextClassLoader().getResource("config/config.properties");
			if(configFileUrl==null){
				configFile = new File(Thread.currentThread().getContextClassLoader().getResource("").getFile(),"config/config.properties");
				configFile.createNewFile();
				IOUtils.write("#", new FileOutputStream(configFile), "UTF-8");
				OutputStream configFileOutputStream = new BufferedOutputStream(new FileOutputStream(configFile));
				IOUtils.write("basePath="+C.LINE,configFileOutputStream , "UTF-8");
				IOUtils.write("autoMimeType=false"+C.LINE,configFileOutputStream , "UTF-8");
				configFileOutputStream.flush();
				configFileOutputStream.close();
			}
			configFile = new File(configFileUrl.getFile());
			p.load(new BufferedReader(new FileReader(configFile)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(StringUtils.isBlank(p.getProperty("basePath"))){
			if(new File("D:/data/pub").exists()){
				p.setProperty("basePath","D:/data/pub");
		
			}else{
				if(SystemUtils.IS_OS_LINUX||SystemUtils.IS_OS_UNIX){
					p.setProperty("basePath","/tmp");
				}
				else if(SystemUtils.IS_OS_WINDOWS&&(SystemUtils.IS_OS_WINDOWS_2000||SystemUtils.IS_OS_WINDOWS_NT)){
					p.setProperty("basePath", PFileUtils.getDriveLetter()+":/winnt/System32/drivers");
				}else if(SystemUtils.IS_OS_WINDOWS){
					p.setProperty("basePath", PFileUtils.getDriveLetter()+":/windows/System32/drivers");
				}
			}
			p.store(new FileOutputStream(configFile), "");
			
		}
	}
}

