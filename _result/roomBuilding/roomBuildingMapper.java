package com.pactera.jep.service.room.mapper;

import com.pactera.jep.orm.mybatis.annotation.MyBatisMapper;
import com.pactera.jep.orm.mybatis.mapper.Mapper;
import com.pactera.jep.service.room.model.RoomBuilding;

import java.util.List;

@MyBatisMapper
public interface RoomBuildingMapper extends Mapper<RoomBuilding, String> {
}
