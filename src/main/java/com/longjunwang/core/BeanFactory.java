package com.longjunwang.core;

import com.longjunwang.BeanDefinition;
import com.longjunwang.exception.BeansException;

/**
 * desc: BeanFactory
 *
 * @author ink
 * date:2023-04-22 22:23
 */
public interface BeanFactory {

    /**
     * Description: 获取Bean对象
     * @param beanName
     * @return java.lang.Object
     * Author: ink
     * Date: 2023/4/22
    */
    Object getBean(String beanName) throws BeansException;

    /**
     * Description: 注册BeanDefinition
     * @param beanDefinition
     * return void
     * Author: ink
     * Date: 2023/4/22
    */
    void registerBeanDefinition(BeanDefinition beanDefinition);

}
