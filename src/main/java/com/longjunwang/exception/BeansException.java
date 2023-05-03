package com.longjunwang.exception;

/**
 * desc: baseException
 *
 * @author ink
 * date:2023-04-22 22:15
 */
public class BeansException extends Exception{
    public BeansException(String errorMsg){
        super(errorMsg);
    }

    public BeansException(Throwable cause) {
        super(cause);
    }
}
