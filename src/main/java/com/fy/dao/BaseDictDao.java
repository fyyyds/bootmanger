package com.fy.dao;

import com.fy.pojo.BaseDict;

import java.util.List;

/**
 * @author: fy
 * @create: 2022-03-24 18:09
 **/
public interface BaseDictDao {
    // 根据类别代码插叙数据字典
    List<BaseDict> selectBaseDictByTypeCode(String typeCode);
}
