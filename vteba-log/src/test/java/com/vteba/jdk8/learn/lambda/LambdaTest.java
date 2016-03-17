package com.vteba.jdk8.learn.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.vteba.jdk8.learn.functionalinterface.Converter;

public class LambdaTest {
	// lambda对匿名内部类的 改进，语法糖
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
	
	// 测试lambda表单时的作用域.像匿名内部类一样，访问外层的final 变量
	@Test
	public void test2() {
		final int num = 1;
		Converter<Integer, String> stringConverter =
		        (from) -> String.valueOf(from + num);
		String i = stringConverter.convert(2);     // 3
		System.out.println(i);
	}
	
	// 测试lambda表单时的作用域.像匿名内部类一样，访问外层的final 变量
	// 外层变量的final修饰符可以去掉，隐含是final的，即在下面不能对num再赋值
	@Test
	public void test3() {
		int num = 1;
		Converter<Integer, String> stringConverter =
		        (from) -> String.valueOf(from + num);
		String result = stringConverter.convert(2);     // 3
		System.out.println(result);
		
		// num = 2; // 会编译错误，因为num是隐含final修饰
	}
}
