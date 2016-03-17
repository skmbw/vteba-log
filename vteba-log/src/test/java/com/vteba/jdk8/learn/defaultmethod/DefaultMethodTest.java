package com.vteba.jdk8.learn.defaultmethod;

import org.junit.Assert;
import org.junit.Test;

public class DefaultMethodTest {
	
	@Test
	public void test() {
		Formula formula = new FormualImpl();
		Assert.assertEquals(10, formula.calculate(100), 0);
		formula.sqrt(16);
		
		// lambda不能访问接口的默认方法
		// Formula formula2 = (a) -> sqrt( a * 100);
	}
}
