package com.vteba.jdk8.learn.deffuncinterface;

import java.util.function.Function;

import org.junit.Test;

/**
 * 将多个功能进行组合。Function 接口有一个参数并且返回一个结果，并附带了一些可以和其他函数组合的默认方法（compose, andThen）
 * 
 * @author yinlei
 * @date 2016年3月17日 上午10:34:08
 */
public class FunctionTest {

	@Test
	public void test() {
		Function<String, Integer> toInteger = Integer::valueOf;

		Function<String, String> backToString = toInteger.andThen(String::valueOf);
		backToString.apply("123"); // "123"
	}
}
