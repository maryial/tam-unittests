package com.epam.tam.unittests;

import org.apache.logging.log4j.*;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class CustomTestListener implements ISuiteListener {
	final static Logger logger = LogManager.getLogger(CustomTestListener.class);
	private static long startTime;
	
	public void onStart(ISuite suite) {
		startTime = System.currentTimeMillis();
		logger.info("Test {} started", suite.getName() );		
	}
	
	public void onFinish(ISuite suite) {
		logger.info("Test {} finished and lasted {} ms", suite.getName(), System.currentTimeMillis() - startTime );
	}
}
