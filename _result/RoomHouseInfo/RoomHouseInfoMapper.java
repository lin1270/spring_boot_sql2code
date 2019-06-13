package com.pactera.jep.service.base.mapper;

import com.pactera.jep.orm.mybatis.annotation.MyBatisMapper;
import com.pactera.jep.orm.mybatis.mapper.Mapper;
import com.pactera.jep.service.base.model.RoomHouseInfo;

import java.util.List;

@MyBatisMapper
public interface RoomHouseInfoMapper extends Mapper<RoomHouseInfo, String> {
}
