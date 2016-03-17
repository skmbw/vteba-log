package com.vteba.jdk8.learn.functionalinterface;

import org.junit.Test;

public class FunctionalInterfaceTest {

	@Test
	public void main() {
		// lambda表达式实现的接口
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer i = converter.convert("10");
		assert i == 10;
		
		// 方法引用实现接口，这里是静态方法，也可以调用对象方法
		Converter<String, Long> longConverter = Long::valueOf;
		System.out.println(longConverter.convert("223"));
		
		// 构造函数引用实现接口
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", 23);
		System.out.println(person.getName() + " : " + person.getAge());
	}

}
