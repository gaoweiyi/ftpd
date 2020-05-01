package com.inputabc.ftpd.web.filter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.inputabc.ftpd.constant.C;
import com.inputabc.ftpd.entity.User;

import net.sf.ehcache.Element;

/**
 * 安全保护过滤器
 * 
 * @author gaoweiyi
 *
 */
public class SecurityFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 进行安全验证，防止恶意攻击
		request.setAttribute("remoteHost", request.getRemoteHost());
		boolean enableRequestSecurityProtection = Boolean.parseBoolean( (String)C.configCache.get("enableRequestSecurityProtection").getObjectValue());
		if(enableRequestSecurityProtection==false){
			chain.doFilter(request, response);
			return;
		}
		long requestIntervalMilliseconds = Long.parseLong((String)C.configCache.get("requestIntervalMilliseconds").getObjectValue());
		long requestContinuousCount = Long.parseLong((String)C.configCache.get("requestContinuousCount").getObjectValue());
		long ipBlockMinute = Long.parseLong((String)C.configCache.get("ipBlockMinute").getObjectValue());
		long maxWarningNumber = Long.parseLong((String)C.configCache.get("maxWarningNumber").getObjectValue());
		
		String remoteHost = request.getRemoteHost();
		//验证此ip是否在黑名单里
		try {
			if(getBlackList().contains(remoteHost)){
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("Bad Request !");
				return;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new RuntimeException(e1);
		}
		Element element = C.appCache.get("requestHostMap");
		if (element == null) {
			C.appCache.put(new Element("requestHostMap", new HashMap<String, User>()));
			element = C.appCache.get("requestHostMap");
		}
		Map<String, User> requestHostMap = (Map<String, User>) element.getObjectValue();
		if (requestHostMap.containsKey(remoteHost)) {
			User user = requestHostMap.get(remoteHost);
			long lastAccessTime = user.getLastAccessTime();// 最后访问时间
			if(user.isWaitingActivation()){
				if((System.currentTimeMillis()-lastAccessTime)>1000*60*ipBlockMinute){
					user.setWaitingActivation(false);//解除锁定状态
				}else{
					response.setContentType("text/html;charset=utf-8");
					response.getWriter().write("用户锁定中。请"+(1000*60*ipBlockMinute-((System.currentTimeMillis()-lastAccessTime)))/1000/60+"分钟后再次尝试！");
					return;
				}
			}
			int continuousAccessCount = user.getContinuousAccessCount();// 连续访问次数
			
			if ((System.currentTimeMillis() - lastAccessTime) > requestIntervalMilliseconds) {
				user.setContinuousAccessCount(user.getContinuousAccessCount()/2);
				user.setLastAccessTime(System.currentTimeMillis());
			} else {
				user.setLastAccessTime(System.currentTimeMillis());
				user.setContinuousAccessCount(++continuousAccessCount);
				if (continuousAccessCount > requestContinuousCount) {// 如果连续访问超过requestContinuousCount次
					user.setWaitingActivation(true);
					user.setIllegalCount(user.getIllegalCount()+1);
					if(user.getIllegalCount()>maxWarningNumber){
						//将用户的ip记录到黑名单
						try {
							addToBlackList(user.getHost());
							response.setContentType("text/html;charset=utf-8");
							response.getWriter().write("Bad Request !");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else{
						response.setContentType("text/html;charset=utf-8");
						response.getWriter().write("用户锁定中。请"+ipBlockMinute+"分钟后再次尝试！");
					}
					return;
				}
			}
			
		} else {
			requestHostMap.put(remoteHost, new User(remoteHost,System.currentTimeMillis()));
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		try {
			File blacklistFile = new File(
					URLDecoder.decode(this.getClass().getResource("/black.list").getFile(), "utf-8"));
			boolean exists = blacklistFile.exists();
			if (exists == false) {
				if (blacklistFile.createNewFile()) {
					return;
				} else {
					throw new RuntimeException("无法创建黑名单文件：black.list");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("无法创建黑名单文件：black.list");
			throw new RuntimeException(e);
		}

	}
	/**
	 * 解析并获取黑名单的ip集合
	 * @return
	 * @throws Exception
	 */
	private List<String> getBlackList() throws Exception{
		List<String> blacklist = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/black.list"),"utf-8"));
		String line = null;
		while((line = br.readLine())!=null){
			line = line.trim();
			if(line.startsWith("#")==false){
				if(line.matches("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$")){
					blacklist.add(line);
				}else if(line.matches("^\\s*((([0-9A-Fa-f]{1,4}:){7}([0-9A-Fa-f]{1,4}|:))|(([0-9A-Fa-f]{1,4}:){6}(:[0-9A-Fa-f]{1,4}|((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){5}(((:[0-9A-Fa-f]{1,4}){1,2})|:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){4}(((:[0-9A-Fa-f]{1,4}){1,3})|((:[0-9A-Fa-f]{1,4})?:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){3}(((:[0-9A-Fa-f]{1,4}){1,4})|((:[0-9A-Fa-f]{1,4}){0,2}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){2}(((:[0-9A-Fa-f]{1,4}){1,5})|((:[0-9A-Fa-f]{1,4}){0,3}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){1}(((:[0-9A-Fa-f]{1,4}){1,6})|((:[0-9A-Fa-f]{1,4}){0,4}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(:(((:[0-9A-Fa-f]{1,4}){1,7})|((:[0-9A-Fa-f]{1,4}){0,5}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:)))(%.+)?\\s*$")){
					blacklist.add(line);
				}else{
					throw new RuntimeException("黑名单有错误");
				}
			}
		}
		return blacklist;
	}
	/**
	 * 将一个ip地址追加到黑名单文件
	 * @param host
	 * @throws Exception
	 */
	private void addToBlackList(String host) throws Exception{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(URLDecoder.decode(this.getClass().getResource("/black.list").getFile(), "utf-8"),true), "utf-8"));
		bw.newLine();
		bw.write(host);
		bw.flush();
		bw.close();
	}
}
