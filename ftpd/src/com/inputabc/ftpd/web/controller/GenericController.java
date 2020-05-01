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
}

