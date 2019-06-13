package com.pactera.jep.service.base.mapper;

import com.pactera.jep.orm.mybatis.annotation.MyBatisMapper;
import com.pactera.jep.orm.mybatis.mapper.Mapper;
import com.pactera.jep.service.base.model.RoomLivingArea;

import java.util.List;

@MyBatisMapper
public interface RoomLivingAreaMapper extends Mapper<RoomLivingArea, String> {
}
