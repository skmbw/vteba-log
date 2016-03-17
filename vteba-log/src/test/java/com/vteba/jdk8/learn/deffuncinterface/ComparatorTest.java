package com.vteba.jdk8.learn.deffuncinterface;

import java.util.Comparator;

import org.junit.Test;

import com.vteba.jdk8.learn.functionalinterface.Person;

/**
 * Comparator 是老Java中的经典接口， Java 8在此之上添加了多种默认方法
 * 
 * @author yinlei
 * @date 2016年3月17日 上午10:47:09
 */
public class ComparatorTest {

	@Test
	public void test() {
		Comparator<Person> comparator = (p1, p2) -> p1.getName().compareTo(p2.getName());
		Person p1 = new Person("John", 11);
		Person p2 = new Person("Alice", 22);
		comparator.compare(p1, p2); // > 0
		comparator.reversed().compare(p1, p2); // < 0
	}
}
