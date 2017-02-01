package com.epam.tam.unittests;

import com.epam.tat.module4.Calculator;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest {

	private Calculator calculator;
	private static final double DELTA = 0.01;
	
	@DataProvider(name = "dataForSum")
	public Object[][] dataForSum() {
		return new Object[][] {
				{0, 0, 0},
				{-1, 0, -1},
				{-10, 10, 0},
				{2, 2, 4}
		};	
	}
	
	@DataProvider(name = "dataForMult")
	public Object[][] dataForMult() {
		return new Object[][] {
				{0, 0, 0},
				{-1, 0, 0},
				{-10, 10, -100},
				{2, 2, 4}
		};	
	}	
	
	@BeforeClass
	public void setUp(){
		calculator = new Calculator();
	}
	
	@AfterClass
	public void cleanUp() {
		calculator = null;
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class, dependsOnGroups = {"basic"})
	public void divideByZeroThrowsException() {
		calculator.div(2, 0);
	}
	
	@Test(dataProvider = "dataForSum", groups = {"basic"})
	public void testSum(long first, long second, long expected) {
		long result = calculator.sum(first, second);
		Assert.assertEquals(result, expected);
	}
	
		
	@Test(dataProvider = "dataForMult", groups = {"basic"})
	public void testMult(long first, long second, long expected) {
		long result = calculator.mult(first, second);
		Assert.assertEquals(result, expected);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void sumTwoMaxLongThrowsException() {
		calculator.sum(Long.MAX_VALUE, Long.MAX_VALUE);
	}
	
	@Test(groups = {"basic"})
	public void testPositive() {
		boolean result = calculator.isPositive(7);
		Assert.assertTrue(result);
	}
	
	@Test(groups = {"basic"})
	public void testNegative() {
		boolean result = calculator.isNegative(-7);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testZeroNotEqualPositiveOrNegative() {
		boolean neg = calculator.isNegative(0);
		boolean pos = calculator.isPositive(0);
		Assert.assertFalse(neg && pos);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testRootSquareOfNegativeNumberThrowsException() {
		calculator.sqrt(-1);
	}
	
	@Test(groups = {"basic"})
	public void testCos() {
		double result = calculator.cos(1);
		Assert.assertEquals(result, 0.540, DELTA);		
	}	
}
