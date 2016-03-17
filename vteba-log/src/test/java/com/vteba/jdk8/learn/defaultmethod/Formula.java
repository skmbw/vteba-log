package com.vteba.jdk8.learn.defaultmethod;

public interface Formula {
    double calculate(int a);
    
    // 默认方法
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
