package com.kosea.kmove30;

import org.apache.log4j.Logger;

public class LogTest1 {
	
	private final Logger logger = Logger.getLogger(LogTest1.class);
	
	public void printlog(String msg) {
		
		logger.info(msg);
		logger.debug(msg);
		
	}
	
	public static void main(String[] args){
		
		LogTest1 logTest1 = new LogTest1();
		logTest1.printlog("로그 테스트 중입니다.");
		
	}

}
