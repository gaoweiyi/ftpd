package com.inputabc.ftpd.entity;
/**
 * 
 * @author gaoweiyi
 *
 */
public class User {
	private String host;//用户的ip
	private long lastAccessTime;//最后访问的时间
	private int continuousAccessCount;//连续访问次数。超过10次记一次非法
	private int illegalCount;//非法次数。超过2次计入黑名单
	private boolean waitingActivation;//如果为true，表示用户处于请求封锁状态
	public User() {
	}
	public User(String host, long lastAccessTime) {
		this.host = host;
		this.lastAccessTime = lastAccessTime;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public long getLastAccessTime() {
		return lastAccessTime;
	}
	public void setLastAccessTime(long lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	public int getContinuousAccessCount() {
		return continuousAccessCount;
	}
	public void setContinuousAccessCount(int continuousAccessCount) {
		this.continuousAccessCount = continuousAccessCount;
	}
	public int getIllegalCount() {
		return illegalCount;
	}
	public void setIllegalCount(int illegalCount) {
		this.illegalCount = illegalCount;
	}
	public boolean isWaitingActivation() {
		return waitingActivation;
	}
	public void setWaitingActivation(boolean waitingActivation) {
		this.waitingActivation = waitingActivation;
	}
	
}
