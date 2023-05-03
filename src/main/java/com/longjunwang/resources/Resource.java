package com.longjunwang.resources;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * desc: Resource
 *
 * @author ink
 * date:2023-04-22 22:34
 */
public interface Resource<T> {

    boolean hasNext();


    T next();

}
