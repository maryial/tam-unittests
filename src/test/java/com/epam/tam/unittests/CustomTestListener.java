package com.epam.tam.unittests;

import org.testng.ISuite;
import org.testng.ISuiteListener;


public class CustomTestListener implements ISuiteListener {

	public void onFinish(ISuite suite) {
		System.out.println("Test " + suite.getName() + " finished at " + System.currentTimeMillis());
		
	}

	public void onStart(ISuite suite) {
		System.out.println("Test " + suite.getName() + " started at " + System.currentTimeMillis());
		
	}

}
