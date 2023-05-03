package com.longjunwang;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        ClassPathJsonApplicationContext applicationContext = new ClassPathJsonApplicationContext("applicationContext.json");
        MyService myService = (MyService) applicationContext.getBean("myService");
        System.out.println(myService.printParam("hello"));
    }
}
