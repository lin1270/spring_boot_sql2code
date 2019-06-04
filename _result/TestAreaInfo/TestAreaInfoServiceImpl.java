package com.pactera.jep.service.base.service.impl;

import com.pactera.jep.orm.mybatis.mapper.Mapper;
import com.pactera.jep.orm.mybatis.service.MyBatisCRUDService;
import com.pactera.jep.service.base.mapper.TestAreaInfoMapper;
import com.pactera.jep.service.base.model.TestAreaInfo;
import com.pactera.jep.service.base.service.TestAreaInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestAreaInfoServiceImpl
        extends MyBatisCRUDService<TestAreaInfo, String>
        implements TestAreaInfoService
{
    @Autowired
    private TestAreaInfoMapper mapper;

    @Override
    public Mapper<TestAreaInfo,String> getMapper() { return mapper; }
}
