package com.longjunwang;

import com.longjunwang.exception.BeansException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws BeansException {
        ClassPathJsonApplicationContext applicationContext = new ClassPathJsonApplicationContext("applicationContext.json");
        MyService myService = (MyService) applicationContext.getBean("myService");
        System.out.println(myService.printParam("hello"));
    }
}
