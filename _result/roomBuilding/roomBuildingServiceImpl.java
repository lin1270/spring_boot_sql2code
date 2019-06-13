package com.pactera.jep.service.room.service.impl;

import com.pactera.jep.orm.mybatis.mapper.Mapper;
import com.pactera.jep.orm.mybatis.service.MyBatisCRUDService;
import com.pactera.jep.service.room.mapper.RoomBuildingMapper;
import com.pactera.jep.service.room.model.RoomBuilding;
import com.pactera.jep.service.room.service.RoomBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomBuildingServiceImpl
        extends MyBatisCRUDService<RoomBuilding, String>
        implements RoomBuildingService
{
    @Autowired
    private RoomBuildingMapper mapper;

    @Override
    public Mapper<RoomBuilding,String> getMapper() { return mapper; }
}
