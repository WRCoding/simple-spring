package com.longjunwang.resources.json;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.longjunwang.resources.Resource;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * desc: ClassPathJsonResource
 *
 * @author ink
 * date:2023-04-22 22:35
 */
public class ClassPathJsonResource implements Resource<Map> {

    int index = 0;
    List<Map> configList;
    public ClassPathJsonResource(String fileName){
        String config = ResourceUtil.readUtf8Str(fileName);
        JSONArray objects = JSONUtil.parseArray(config);
        configList = JSONUtil.toList(objects, Map.class);
    }


    @Override
    public boolean hasNext() {
        return index < configList.size();
    }

    @Override
    public Map next() {
        return configList.get(index++);
    }
}
