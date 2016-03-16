package com.vteba.jdk8.learn.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class LambdaTest {
	
	@Test
	public void test() {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		
		Collections.sort(names, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return b.compareTo(a);
		    }
		});
		
		System.out.println(names);
		
		names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, (String a, String b) -> {
		    return b.compareTo(a);
		});
		System.out.println(names);
		
		names = Arrays.asList("peter", "anna", "mike", "xenia");
		// 对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字
		Collections.sort(names, (String a, String b) -> b.compareTo(a));
		System.out.println(names);
		
		names = Arrays.asList("peter", "anna", "mike", "xenia");
		
		// Java编译器可以自动推导出参数类型，所以你可以不用再写一次类型
		Collections.sort(names, (a, b) -> b.compareTo(a));
		System.out.println(names);
	}
	
}
