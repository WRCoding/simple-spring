package com.longjunwang;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;

import java.net.URL;
import java.util.*;

/**
 * desc: ClassPathJsonApplicationContext
 *
 * @author ink
 * date:2023-04-22 21:40
 */
public class ClassPathJsonApplicationContext {
    private List<BeanDefinition> beanDefinitions = new ArrayList<BeanDefinition>();
    private Map<String, Object> instanceMap = new HashMap<String, Object>();

    public ClassPathJsonApplicationContext(String fileName){
        parseConfig(fileName);
        initBean();
    }

    private void parseConfig(String fileName) {
        String config = ResourceUtil.readUtf8Str(fileName);
        JSONArray objects = JSONUtil.parseArray(config);
        List<Map> maps = JSONUtil.toList(objects, Map.class);
        for (Map map : maps) {
            BeanDefinition beanDefinition = new BeanDefinition((String) map.get("id"), (String) map.get("className"));
            beanDefinitions.add(beanDefinition);
        }
    }

    private void initBean() {
        try {
            for (BeanDefinition beanDefinition : beanDefinitions) {
                String className = beanDefinition.getClassName();
                Object instance = Class.forName(className).newInstance();
                instanceMap.put(beanDefinition.getId(), instance);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Object getBean(String id){
        Object o = instanceMap.get(id);
        if (Objects.isNull(o)){
            throw new NullPointerException(String.format("%s not exist", id));
        }
        return o;
    }

    public static void main(String[] args) {
        ClassPathJsonApplicationContext applicationContext = new ClassPathJsonApplicationContext("applicationContext.json");
    }
}
