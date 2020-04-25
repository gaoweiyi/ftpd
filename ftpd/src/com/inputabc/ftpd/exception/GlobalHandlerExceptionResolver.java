package com.inputabc.ftpd.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

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
		String msg;

		if (exception instanceof MyException) {
			msg = exception.getMessage();
		} else {
			StringWriter out = new StringWriter();
			PrintWriter s = new PrintWriter(out);
			exception.printStackTrace(s);
			msg = out.toString();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", msg);
		modelAndView.addObject("contextPath", req.getContextPath());
		modelAndView.setViewName("err/500");
		return modelAndView;
	}

}
