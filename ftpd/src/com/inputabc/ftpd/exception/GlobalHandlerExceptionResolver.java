package com.inputabc.ftpd.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author gaoweiyi
 *
 */
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse arg1, Object arg2,
			Exception exception) {
		exception.printStackTrace();
		return new ModelAndView("redirect:/index.html");
	}

}
