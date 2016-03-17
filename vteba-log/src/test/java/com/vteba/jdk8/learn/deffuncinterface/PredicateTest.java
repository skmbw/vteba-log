package com.vteba.jdk8.learn.deffuncinterface;

import java.util.Objects;
import java.util.function.Predicate;

import org.junit.Test;

/**
 * jdk8谓词测试（与或非），是一个函数式接口，方法是test，用来判断一个boolean类型。
 * 可以与其他的谓词进行结合
 * 
 * @author yinlei
 * @date 2016年3月17日 上午10:29:37
 */
public class PredicateTest {

	@Test
	public void test() {
		Predicate<String> predicate = (s) -> s.length() > 0;
		predicate.test("foo"); // true
		predicate.negate().test("foo"); // false
		Predicate<Boolean> nonNull = Objects::nonNull;
		System.out.println(nonNull.test(true));
		Predicate<Boolean> isNull = Objects::isNull;
		isNull.test(null);
		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
		isNotEmpty.test("aa");
	}
}
