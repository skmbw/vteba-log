package com.vteba.jdk8.learn.functionalinterface;

public interface PersonFactory<P extends Person> {
    P create(String firstName, int age);
}
