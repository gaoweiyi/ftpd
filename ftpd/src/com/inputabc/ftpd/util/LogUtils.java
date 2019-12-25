package com.inputabc.ftpd.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 导出错误/异常的日志
 * 将控制台打印的错误和异常信息导出到一个文件中
 * 使用说明：
 * 调用log方法，将异常对象作为参数传入即可
 * 例子：
 * catch(Exception e) {
			LogUtils.export(e);
		}
 *	@version 3.1
 * @author 高伟益 
 *
 */
public class LogUtils {
	private static PrintWriter pw;
	static {
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter("/tmp/ftpd.log",true)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private LogUtils(){}
	public static PrintWriter getWriter() {
		return pw;
	}
	public static void begin() {
		pw.println();
		pw.println("----------");
		pw.println();
		pw.flush();
	}
	public final static void time() {
		pw.print("datatime -> ");
		pw.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		pw.println();
		pw.flush();
	}
	public static void all() {
		begin();
		time();
	}
	public static void flush() {
		pw.flush();
	}
	@Deprecated
	public static void export(Throwable e){
		all();
		e.printStackTrace(getWriter());
		flush();
	}
	public static void log(Throwable e){
		export(e);
	}
}
