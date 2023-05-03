package com.longjunwang.core;

import com.longjunwang.BeanDefinition;
import com.longjunwang.exception.BeansException;

import java.util.*;

/**
 * desc: SimpleBeanFactory
 *
 * @author ink
 * date:2023-04-22 22:25
 */
public class SimpleBeanFactory implements BeanFactory{


    private Map<String, BeanDefinition> definitionMap = new HashMap<>();

    private Map<String, Object> singletons = new HashMap<>();

    public SimpleBeanFactory() {
    }


    @Override
    public Object getBean(String beanName) throws BeansException {
        Object bean = singletons.get(beanName);
        if (Objects.isNull(bean)){
            BeanDefinition beanDefinition = definitionMap.get(beanName);
            if (Objects.isNull(beanDefinition)){
                throw new BeansException(String.format("%s不存在",beanName));
            }
            try {
                bean = Class.forName(beanDefinition.getClassName()).newInstance();
                singletons.put(beanName, bean);
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                throw new BeansException(e);
            }
        }
        return singletons.get(beanName);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        definitionMap.put(beanDefinition.getId(), beanDefinition);
    }
}
