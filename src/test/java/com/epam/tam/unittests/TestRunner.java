package com.epam.tam.unittests;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

public class TestRunner {
	public static void main(String[] args) {
		TestNG tng = new TestNG();
		tng.addListener(new CustomTestListener());
		XmlSuite suite = new XmlSuite();
		//suite.setName("calcb");
		List<String> files = new ArrayList<String>();
		files.addAll(new ArrayList<String>() {
			{
				add("./src/test/resources/suites/calculator.xml");        
			}
		});
		suite.setSuiteFiles(files);        
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		tng.setXmlSuites(suites);
		tng.run();    
	}
	
}