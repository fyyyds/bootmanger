package com.fy.service;

import com.fy.pojo.BaseDict;

import java.util.List;

/**
 * @author: fy
 * @create: 2022-03-24 18:12
 **/
public interface BaseDictService {
    // 根据类别代码查询数据字典
    List<BaseDict> selectBaseDictByTypeCode(String typeCode);
}
