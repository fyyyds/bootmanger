package com.fy.service.impl;

import com.fy.dao.BaseDictDao;
import com.fy.pojo.BaseDict;
import com.fy.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: fy
 * @create: 2022-03-24 18:12
 **/
@Service
public class BaseDictServiceImpl implements BaseDictService {
    @Autowired
    private BaseDictDao baseDictDao;

    @Override
    public List<BaseDict> selectBaseDictByTypeCode(String typeCode) {
        return baseDictDao.selectBaseDictByTypeCode(typeCode);
    }
}
