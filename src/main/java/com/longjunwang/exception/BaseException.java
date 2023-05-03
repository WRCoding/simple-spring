package com.longjunwang.exception;

/**
 * desc: baseException
 *
 * @author ink
 * date:2023-04-22 22:15
 */
public class BaseException extends Exception{
    public BaseException(String errorMsg){
        super(errorMsg);
    }
}
