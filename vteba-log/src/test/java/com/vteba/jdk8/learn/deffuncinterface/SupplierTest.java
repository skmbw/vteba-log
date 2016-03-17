package com.vteba.jdk8.learn.deffuncinterface;

import java.util.function.Supplier;

import org.junit.Test;

import com.vteba.jdk8.learn.functionalinterface.Person;

/**
 * Supplier 接口返回一个任意范型的值，和Function接口不同的是该接口没有任何参数
 * 
 * @author yinlei
 * @date 2016年3月17日 上午10:38:05
 */
public class SupplierTest {
	
	@Test
	public void test() {
		Supplier<Person> personSupplier = Person::new;
		personSupplier.get();   // new Person
	}
}
