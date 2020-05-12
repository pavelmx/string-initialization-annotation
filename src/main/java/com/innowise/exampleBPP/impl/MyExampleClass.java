package com.innowise.exampleBPP.impl;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyExampleClass {

    @InjectString("pavek")
    private String name;

    @InjectString("minsk")
    private String city;

    @InjectString("4")
    private String count;

    @PostConstruct
    public void init() {
        System.out.println("phase 2");
        System.out.println("name " + name);
        System.out.println("city " + city);
        System.out.println("count " + count);
    }

    public MyExampleClass() {
        System.out.println("phase 1");
        System.out.println("name " + name);
        System.out.println("city " + city);
        System.out.println("count " + count);
    }
}
