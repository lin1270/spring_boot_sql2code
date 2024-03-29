CREATE TABLE `room_living_area` (
  `ID_` varchar(64) NOT NULL COMMENT '主键',
  `NAME_` varchar(255) NOT NULL COMMENT '名字',
  `SHORT_NAME_` varchar(64) DEFAULT NULL COMMENT '简称',
  `INTRODUCTION_` varchar(64) DEFAULT NULL COMMENT '简介',
  `ADDRESS_` varchar(64) DEFAULT NULL COMMENT '地址',
  `PROPERTY_ID_` varchar(64) DEFAULT NULL COMMENT '物业公司ID',
  `REGION_CODE_` varchar(16) DEFAULT NULL COMMENT '所属区域编码',
  `FLOOR_AREA_` varchar(64) DEFAULT NULL COMMENT '占地面积',
  `BUILDING_AREA_` varchar(64) DEFAULT NULL COMMENT '建筑面积',
  `GREEN_RATE_` varchar(32) DEFAULT NULL COMMENT ' 绿化率',
  `VOLUME_RATE_` varchar(32) DEFAULT NULL COMMENT '容积率',
  `IMAGES_` varchar(255) DEFAULT NULL COMMENT '图片',
  `LAT_` varchar(64) DEFAULT NULL COMMENT '纬度',
  `LNG_` varchar(64) DEFAULT NULL COMMENT '经度',
  `TENANT_ID_` varchar(64) DEFAULT NULL COMMENT '租户',
  `DELFLAG_` varchar(1) DEFAULT NULL COMMENT '逻辑删除标记。0-否；1-是；',
  `CREATED_BY_ID_` varchar(64) DEFAULT NULL COMMENT '创建人ID',
  `CREATED_BY_NAME_` varchar(64) DEFAULT NULL COMMENT '创建人名称',
  `CREATED_TIME_` datetime DEFAULT NULL COMMENT '创建时间',
  `MODIFIED_BY_ID_` varchar(64) DEFAULT NULL COMMENT '修改人ID',
  `MODIFIED_BY_NAME_` varchar(64) DEFAULT NULL COMMENT '修改人名称',
  `MODIFIED_TIME_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `DISPLAY_ORDER_` int(11) DEFAULT NULL COMMENT '显示序号',
  `VERSION_` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`ID_`),
  KEY `fk_room_living_area_PROPERTY_ID` (`PROPERTY_ID_`),
  CONSTRAINT `fk_room_living_area_PROPERTY_ID` FOREIGN KEY (`PROPERTY_ID_`) REFERENCES `room_property` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='小区';