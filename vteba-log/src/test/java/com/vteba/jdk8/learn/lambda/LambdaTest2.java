package com.vteba.jdk8.learn.lambda;

import org.junit.Test;

import com.vteba.jdk8.learn.functionalinterface.Converter;

/**
 * lambda表达式 对类的实例变量和静态变量 既能读  又能写。和局部变量不同，只能读。不能写。
 * 
 * @author yinlei
 * @date 2016年3月17日 上午10:02:07
 */
public class LambdaTest2 {
    static int outerStaticNum;
    int outerNum;
    
    @Test
    public void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };
        System.out.println(stringConverter1.convert(11));
        
        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
        
        System.out.println(stringConverter2.convert(12));
    }
}
