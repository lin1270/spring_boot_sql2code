package com.pactera.jep.service.room.model;


import com.pactera.jep.entity.BasePO;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.sql.Time;
import java.sql.Timestamp;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "room_building")
public class RoomBuilding extends BasePO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty("主键")
	@Column(name = "ID_")
	private String id;

	@ApiModelProperty("名字")
	@Column(name = "NAME_")
	private String name;

	@ApiModelProperty("层数")
	@Column(name = "FLOORS_")
	private String floors;

	@ApiModelProperty("高度")
	@Column(name = "HIGH_")
	private String high;

	@ApiModelProperty("户数")
	@Column(name = "ROOM_NUM_")
	private String roomNum;

	@ApiModelProperty("预售证")
	@Column(name = "SALE_PERMIT_")
	private String salePermit;

	@ApiModelProperty("项目编码")
	@Column(name = "PROJECT_CODE_")
	private String projectCode;

	@ApiModelProperty("项目分期编码")
	@Column(name = "SUB_PROJECT_CODE_")
	private String subProjectCode;

	@ApiModelProperty("小区ID")
	@Column(name = "AREA_ID_")
	private String areaId;

	@ApiModelProperty("小区名字")
	@Column(name = "AREA_NAME_")
	private String areaName;

	@ApiModelProperty("售楼部ID")
	@Column(name = "SALES_CENTER_ID_")
	private String salesCenterId;

	@ApiModelProperty("楼盘编码")
	@Column(name = "BUILD_SALES_CODE_")
	private String buildSalesCode;

	@ApiModelProperty("物业管理费用。单位 元/平米/月。")
	@Column(name = "PROPERTY_PRICE_")
	private Double propertyPrice;

	@ApiModelProperty("楼型")
	@Column(name = "BUILDING_TYPE_")
	private String buildingType;

	@ApiModelProperty("电梯")
	@Column(name = "ELEVATOR_")
	private String elevator;

	@ApiModelProperty("纬度")
	@Column(name = "LAT_")
	private String lat;

	@ApiModelProperty("经度")
	@Column(name = "LNG_")
	private String lng;

	@ApiModelProperty("年代")
	@Column(name = "AGE_")
	private Integer age;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFloors() {
		return floors;
	}

	public void setFloors(String floors) {
		this.floors = floors;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getSalePermit() {
		return salePermit;
	}

	public void setSalePermit(String salePermit) {
		this.salePermit = salePermit;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getSubProjectCode() {
		return subProjectCode;
	}

	public void setSubProjectCode(String subProjectCode) {
		this.subProjectCode = subProjectCode;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getSalesCenterId() {
		return salesCenterId;
	}

	public void setSalesCenterId(String salesCenterId) {
		this.salesCenterId = salesCenterId;
	}

	public String getBuildSalesCode() {
		return buildSalesCode;
	}

	public void setBuildSalesCode(String buildSalesCode) {
		this.buildSalesCode = buildSalesCode;
	}

	public Double getPropertyPrice() {
		return propertyPrice;
	}

	public void setPropertyPrice(Double propertyPrice) {
		this.propertyPrice = propertyPrice;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public String getElevator() {
		return elevator;
	}

	public void setElevator(String elevator) {
		this.elevator = elevator;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RoomBuilding == false) {
            return false;
        }
        if(this == obj) {
            return true;
        }
        RoomBuilding other = (RoomBuilding)obj;
        return new EqualsBuilder()
                .append(getId(),other.getId())
                .isEquals();
    }
}
