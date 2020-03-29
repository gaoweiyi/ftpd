package com.inputabc.ftpd.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
public class UserRequestListener implements ServletRequestListener {
    public void requestDestroyed(ServletRequestEvent arg0)  { 
    }
    public void requestInitialized(ServletRequestEvent sre)  { 
    	sre.getServletRequest().setAttribute("remoteHost", ((HttpServletRequest)sre.getServletRequest()).getRemoteHost());
    }
	
}
