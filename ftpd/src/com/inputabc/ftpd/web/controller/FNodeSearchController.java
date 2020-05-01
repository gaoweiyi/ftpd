package com.inputabc.ftpd.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.inputabc.ftpd.constant.C;
import com.inputabc.ftpd.entity.FNodePage;
import com.inputabc.ftpd.entity.SearchEntity;
import com.inputabc.ftpd.service.FNodeSearchService;
/**
 * 
 * @author gaoweiyi
 *
 */
@Controller
@RequestMapping("fnodeSearchController.do")
public class FNodeSearchController {
	@Autowired
	private FNodeSearchService fnss;
	@RequestMapping(params="search")
	public ModelAndView search(HttpSession session,HttpServletResponse response,@RequestParam(defaultValue="")String content,@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="55")int pageSize,@RequestParam(defaultValue="0")Integer sortMethod) throws Exception{
		content = content.trim();
		if(content.length()>30){
			return null;
		}
		if("".equals(content)){
			return new ModelAndView("redirect:/fnodeController.do?openDir&path=/");
		}
		session.setAttribute("searchEntity", new SearchEntity(content, page));
		session.setMaxInactiveInterval(3600*24*7);
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setPath("/");
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		Boolean sortByNameFlag = (Boolean) session.getAttribute("sortByNameFlag");
		Boolean sortByModifiedFlag = (Boolean) session.getAttribute("sortByModifiedFlag");
		Boolean sortByTypeFlag = (Boolean) session.getAttribute("sortByTypeFlag");
		Boolean sortBySizeFlag = (Boolean) session.getAttribute("sortBySizeFlag");
		if(sortByNameFlag==null){
			session.setAttribute("sortByNameFlag", false);
		}
		if(sortByModifiedFlag==null){
			session.setAttribute("sortByModifiedFlag", false);
		}
		if(sortByTypeFlag==null){
			session.setAttribute("sortByTypeFlag", false);
		}
		if(sortBySizeFlag==null){
			session.setAttribute("sortBySizeFlag", false);
		}
		
		FNodePage fNodePage = fnss.search(content, page,pageSize,sortMethod,session);
		if(fNodePage.getData().size()>0){
			//保存搜索信息到session
			Map<String,Object> searchParams = new HashMap<>();
			searchParams.put("content", content);
			searchParams.put("page", page);
			searchParams.put("pageSize", pageSize);
			searchParams.put("sortMethod",sortMethod);
			session.setAttribute("searchParams", searchParams);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("fnodePage",fNodePage);
		mv.addObject("pageSize", pageSize);
		mv.addObject("page", page);
		mv.addObject("content", content);
		String basePath = C.configCache.get("basePath").getObjectValue().toString();
		mv.addObject("basePath", basePath);
		mv.addObject("isChildPath", false);
		mv.setViewName("searchresu");
		return mv;
	}
	@RequestMapping(params="toSearchPage")
	public ModelAndView toSearchPage(){
		return new ModelAndView("search");
	}
}
