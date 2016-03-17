package com.vteba.jdk8.learn.deffuncinterface;

import java.util.function.Consumer;

import org.junit.Test;

import com.vteba.jdk8.learn.functionalinterface.Person;

/**
 * Consumer 接口表示执行在单个参数上的操作
 * 
 * @author yinlei
 * @date 2016年3月17日 上午10:49:22
 */
public class ConsumerTest {

	@Test
	public void test() {
		Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getName());
		greeter.accept(new Person("Luke", 33));
	}
}
