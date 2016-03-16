package com.vteba.jdk8.learn.defaultmethod;

import org.junit.Assert;
import org.junit.Test;

public class DefaultMethodTest {
	
	@Test
	public void test() {
		Formula formula = new FormualImpl();
		Assert.assertEquals(10, formula.calculate(100), 0);
		formula.sqrt(16);
	}
}
