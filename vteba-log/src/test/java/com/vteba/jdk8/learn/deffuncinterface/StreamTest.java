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
	}
}
