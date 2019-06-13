package com.pactera.jep.service.base.model;


import com.pactera.jep.entity.BasePO;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.sql.Time;
import java.sql.Timestamp;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "room_living_area")
public class RoomLivingArea extends BasePO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty("主键")
	@Column(name = "ID_")
	private String id;

	@ApiModelProperty("名字")
	@Column(name = "NAME_")
	private String name;

	@ApiModelProperty("简称")
	@Column(name = "SHORT_NAME_")
	private String shortName;

	@ApiModelProperty("简介")
	@Column(name = "INTRODUCTION_")
	private String introduction;

	@ApiModelProperty("地址")
	@Column(name = "ADDRESS_")
	private String address;

	@ApiModelProperty("物业公司ID")
	@Column(name = "PROPERTY_ID_")
	private String propertyId;

	@ApiModelProperty("所属区域编码")
	@Column(name = "REGION_CODE_")
	private String regionCode;

	@ApiModelProperty("占地面积")
	@Column(name = "FLOOR_AREA_")
	private String floorArea;

	@ApiModelProperty("建筑面积")
	@Column(name = "BUILDING_AREA_")
	private String buildingArea;

	@ApiModelProperty(" 绿化率")
	@Column(name = "GREEN_RATE_")
	private String greenRate;

	@ApiModelProperty("容积率")
	@Column(name = "VOLUME_RATE_")
	private String volumeRate;

	@ApiModelProperty("图片")
	@Column(name = "IMAGES_")
	private String images;

	@ApiModelProperty("纬度")
	@Column(name = "LAT_")
	private String lat;

	@ApiModelProperty("经度")
	@Column(name = "LNG_")
	private String lng;


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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(String floorArea) {
		this.floorArea = floorArea;
	}

	public String getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(String buildingArea) {
		this.buildingArea = buildingArea;
	}

	public String getGreenRate() {
		return greenRate;
	}

	public void setGreenRate(String greenRate) {
		this.greenRate = greenRate;
	}

	public String getVolumeRate() {
		return volumeRate;
	}

	public void setVolumeRate(String volumeRate) {
		this.volumeRate = volumeRate;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
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


	
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RoomLivingArea == false) {
            return false;
        }
        if(this == obj) {
            return true;
        }
        RoomLivingArea other = (RoomLivingArea)obj;
        return new EqualsBuilder()
                .append(getId(),other.getId())
                .isEquals();
    }
}
