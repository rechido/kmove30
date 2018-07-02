package com.kosea.kmove30;

import org.apache.log4j.Logger;

// DAO (Data Access Object)
public class Member {
	
	private final Logger logger = Logger.getLogger(Member.class);
	
	private int mNo;
	private String id;
	private String password;
	
	public Member() {
		// 기본생성자
	}
	
	public Member(int mNo, String id, String password) {
		super();
		this.mNo = mNo;
		this.id = id;
		this.password = password;
	}
	
	public void printlog(String logMessage) {
		
		logger.info(logMessage);
	}
	
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
