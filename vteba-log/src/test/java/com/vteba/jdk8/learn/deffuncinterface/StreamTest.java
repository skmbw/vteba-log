package com.vteba.jdk8.learn.deffuncinterface;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * java.util.Stream 表示能应用在一组元素上一次执行的操作序列。Stream
 * 操作分为中间操作或者最终操作两种，最终操作返回一特定类型的计算结果，而中间操作返回Stream本身，这样你就可以将多个操作依次串起来。Stream
 * 的创建需要指定一个数据源，比如 java.util.Collection的子类，List或者Set，
 * Map不支持。Stream的操作可以串行执行或者并行执行。
 * 
 * @author yinlei
 * @date 2016年3月17日 上午10:50:54
 */
public class StreamTest {

	@Test
	public void test() {
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");

		// filter过滤

		// 过滤通过一个predicate接口来过滤并只保留符合条件的元素，该操作属于中间操作，
		// 所以我们可以在过滤后的结果来应用其他Stream操作（比如forEach）。forEach
		// 需要一个函数来对过滤后的元素依次执行。forEach是一个最终操作，所以我们不能在forEach之后来执行其他Stream操作。
		stringCollection.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);
		// "aaa2", "aaa1"

		// sort排序
		
		// 排序是一个中间操作，返回的是排序好后的Stream。如果你不指定一个自定义的Comparator则会使用默认排序。
		stringCollection.stream().sorted().filter((s) -> s.startsWith("a")).forEach(System.out::println);
		// "aaa1", "aaa2"
	}
}
