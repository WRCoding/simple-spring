package com.longjunwang;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.longjunwang.core.BeanFactory;
import com.longjunwang.core.SimpleBeanFactory;
import com.longjunwang.exception.BeansException;
import com.longjunwang.resources.Resource;
import com.longjunwang.resources.json.ClassPathJsonParse;
import com.longjunwang.resources.json.ClassPathJsonResource;

import java.net.URL;
import java.util.*;

/**
 * desc: ClassPathJsonApplicationContext
 *
 * @author ink
 * date:2023-04-22 21:40
 */
public class ClassPathJsonApplicationContext implements BeanFactory {

    private BeanFactory beanFactory;

    public ClassPathJsonApplicationContext(String fileName) {
        Resource resource = new ClassPathJsonResource(fileName);
        this.beanFactory = new SimpleBeanFactory();
        ClassPathJsonParse parse = new ClassPathJsonParse(beanFactory);
        parse.loadBeanDefinition(resource);
    }



    public static void main(String[] args) {
        ClassPathJsonApplicationContext applicationContext = new ClassPathJsonApplicationContext("applicationContext.json");
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return getBeanFactory().getBean(beanName);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        getBeanFactory().registerBeanDefinition(beanDefinition);
    }
}
