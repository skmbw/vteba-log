package com.vteba.jdk8.learn.functionalinterface;

/**
 * 这个注解可以不要，只有一个方法的接口，被认为是函数式接口。默认方法 不包含在内
 * @param <F>
 * @param <T>
 * @author yinlei
 * @date 2016年3月16日 下午8:52:31
 */
@FunctionalInterface
public interface Converter<F, T> {
	T convert(F from);
}
