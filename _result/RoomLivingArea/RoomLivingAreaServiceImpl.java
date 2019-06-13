package com.pactera.jep.service.base.service.impl;

import com.pactera.jep.orm.mybatis.mapper.Mapper;
import com.pactera.jep.orm.mybatis.service.MyBatisCRUDService;
import com.pactera.jep.service.base.mapper.RoomLivingAreaMapper;
import com.pactera.jep.service.base.model.RoomLivingArea;
import com.pactera.jep.service.base.service.RoomLivingAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomLivingAreaServiceImpl
        extends MyBatisCRUDService<RoomLivingArea, String>
        implements RoomLivingAreaService
{
    @Autowired
    private RoomLivingAreaMapper mapper;

    @Override
    public Mapper<RoomLivingArea,String> getMapper() { return mapper; }
}
