package com.inputabc.ftpd.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {

	public ModelAndView resolveException1(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {

		// 声明异常信息
		String msg;

		// 判断是否是预期异常
		if (exception instanceof MyException) {
			// 如果是预期异常，获取异常信息
			msg = exception.getMessage();
		} else {
			// 如果是运行时异常，获取异常信息，主要应该获取的是异常堆栈中的异常详情信息
			// 以下代码不要求大家掌握，只需要知道这回事
			StringWriter out = new StringWriter();
			PrintWriter s = new PrintWriter(out);
			exception.printStackTrace(s);
			msg = out.toString();

			// msg = exception.getMessage();
		}

		// 把异常信息发给相关人员。邮件，短信
		// TODO

		// 给用户一个友好的提示
		ModelAndView modelAndView = new ModelAndView();

		// 设置异常数据
		modelAndView.addObject("message", msg);

		// 设置友好提示的页面
		modelAndView.setViewName("page/500");

		return modelAndView;
	}

	public ModelAndView resolveException11(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		return null;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		return null;
	}

}

