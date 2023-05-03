package com.longjunwang.resources.json;

import com.longjunwang.BeanDefinition;
import com.longjunwang.core.BeanFactory;
import com.longjunwang.resources.Resource;

import java.util.Map;

/**
 * desc: ClassPathJsonParse
 *
 * @author ink
 * date:2023-04-22 22:40
 */
public class ClassPathJsonParse {

    private BeanFactory beanFactory;


    public ClassPathJsonParse(BeanFactory beanFactory){
        this.beanFactory = beanFactory;
    }

    public void loadBeanDefinition(Resource resource){
        while (resource.hasNext()){
            Map map = (Map) resource.next();
            BeanDefinition beanDefinition = new BeanDefinition((String) map.get("id"), (String) map.get("className"));
            this.beanFactory.registerBeanDefinition(beanDefinition);
        }
    }
}
