package com.inputabc.ftpd.exception;
/**
 * 
 * @author gaoweiyi
 *
 */
public class MyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7125772444638154023L;
	private String message;

	public MyException() {
		super();
	}

	public MyException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

