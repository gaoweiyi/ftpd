package com.inputabc.ftpd.web.controller;

import java.io.BufferedInputStream;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inputabc.ftpd.constant.C;
import com.inputabc.ftpd.entity.FNode;
import com.inputabc.ftpd.service.FNodeService;

@Controller
@RequestMapping("fnodeController.do")
public class FNodeController {
	@Autowired
	private FNodeService fnodeService;
	@RequestMapping(params = "openDir")
	public ModelAndView openDir(HttpServletRequest request,HttpServletResponse response,String path){
		try {
			path = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		String basePath = C.configCache.get("basePath").getObjectValue().toString();
		List<FNode> fnodes = fnodeService.listFiles(basePath.replace("\\", "/"), path.replace("\\", "/"),0,request.getSession());
		ModelAndView mv = new ModelAndView();
		ModelMap modelMap = mv.getModelMap();
		modelMap.addAttribute("fnodes", fnodes);
		if("/".equals(path.replace("\\", "/"))){
			modelMap.addAttribute("isChildPath", false);
		}else{
			modelMap.addAttribute("isChildPath", true);
		}
		if(path.startsWith("/")==false){
			path = "/".concat(path);
		}
		modelMap.addAttribute("mainPath", path);
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping(params = "backDir")
	public ModelAndView backDir(HttpServletRequest request,HttpServletResponse response,String currentPath){
		String basePath = C.configCache.get("basePath").getObjectValue().toString();
		ModelAndView mv = new ModelAndView();
		ModelMap modelMap = mv.getModelMap();
		//为了保证程序的稳定性
		if(new File(basePath).toString().equals(new File(basePath,currentPath).toString())==false){
			String[] split = new File(basePath,currentPath).getParent().replace("\\", "/").split(basePath);
			String mainPath = null;
			if(split.length>1){
				mainPath = split[1].replace("\\", "/");	
			}else{
				mainPath = "/";
			}
			
			if("/".equals(mainPath)){
				modelMap.addAttribute("isChildPath", false);
			}else{
				modelMap.addAttribute("isChildPath", true);
			}
			List<FNode> fnodes = fnodeService.listFiles(basePath, mainPath,0,request.getSession());
			modelMap.addAttribute("fnodes",fnodes);
			if(mainPath.startsWith("/")==false){
				mainPath = "/".concat(mainPath);
			}
			modelMap.addAttribute("mainPath", mainPath);
		}else{
			modelMap.addAttribute("isChildPath", false);
			modelMap.addAttribute("fnodes", fnodeService.listFiles(basePath.replace("\\", "/"),currentPath.replace("\\", "/"),0,request.getSession()));
			modelMap.addAttribute("mainPath", currentPath);
		}
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping(params = "dlFile")
	public void dlFile(HttpServletRequest request,HttpServletResponse response,String path) throws IOException{
		try {
			path = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		String basePath = C.configCache.get("basePath").getObjectValue().toString();
		File file = new File(basePath,path);
		String filename = new File(basePath,path).getName();
		Boolean autoMimeType = Boolean.valueOf(C.configCache.get("autoMimeType").getObjectValue().toString().toLowerCase());
		String contentDispositionMethod = "";
		if(autoMimeType){
			response.setContentType(request.getServletContext().getMimeType(filename));
			contentDispositionMethod = "inline";
		}else{
			response.setContentType("application/octet-stream");
			contentDispositionMethod = "attachment";
		}
		
		filename = URLEncoder.encode(filename, "UTF-8");

		String userAgent = request.getHeader("user-agent");
		if(userAgent.contains("Trident")){
			response.setHeader("content-disposition", contentDispositionMethod+";filename="+filename);
		}else{
			response.setHeader("content-disposition", contentDispositionMethod+";filename*=UTF-8''"+filename);
		}
		
		response.setHeader("Content-Length", ""+file.length());
		ServletOutputStream out = response.getOutputStream();
		InputStream in = new BufferedInputStream(new FileInputStream(new File(basePath,path).toString()));
		IOUtils.copy(in, out);
	}
	@RequestMapping(params = "reloadDir")
	public ModelAndView reloadDir(HttpServletRequest request,HttpServletResponse response,Boolean isChildPath,Integer sortMethod,String path){
		try {
			path = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		String basePath = C.configCache.get("basePath").getObjectValue().toString();
		List<FNode> fnodes = fnodeService.listFiles(basePath, path,sortMethod,request.getSession());
		ModelAndView mv = new ModelAndView();
		ModelMap modelMap = mv.getModelMap();
		modelMap.addAttribute("isChildPath", isChildPath);
		modelMap.addAttribute("mainPath", path);
		modelMap.addAttribute("fnodes",fnodes);
		mv.setViewName("index");
		return mv;
	}
}

