package com.pactera.jep.service.base.service.impl;

import com.pactera.jep.orm.mybatis.mapper.Mapper;
import com.pactera.jep.orm.mybatis.service.MyBatisCRUDService;
import com.pactera.jep.service.base.mapper.RoomHouseInfoMapper;
import com.pactera.jep.service.base.model.RoomHouseInfo;
import com.pactera.jep.service.base.service.RoomHouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomHouseInfoServiceImpl
        extends MyBatisCRUDService<RoomHouseInfo, String>
        implements RoomHouseInfoService
{
    @Autowired
    private RoomHouseInfoMapper mapper;

    @Override
    public Mapper<RoomHouseInfo,String> getMapper() { return mapper; }
}
