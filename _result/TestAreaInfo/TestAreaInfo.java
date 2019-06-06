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
@Table(name = "base_area_info")
public class TestAreaInfo extends BasePO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty("ID")
	@Column(name = "ID_")
	private String id;

	@ApiModelProperty("项目名称")
	@Column(name = "AREA_NAME_")
	private String areaName;

	@ApiModelProperty("全称")
	@Column(name = "DISPLAY_NAME_")
	private String displayName;

	@ApiModelProperty("项目/楼盘简介")
	@Column(name = "SUMMARY_")
	private String summary;

	@ApiModelProperty("地址")
	@Column(name = "ADDRESS_")
	private String address;

	@ApiModelProperty("售卖均价")
	@Column(name = "UNIT_PRICE_")
	private String unitPrice;

	@ApiModelProperty("招商电话")
	@Column(name = "TELEPHONE_")
	private String telephone;

	@ApiModelProperty("区域编码")
	@Column(name = "REGION_CODE_")
	private String regionCode;

	@ApiModelProperty("售卖状态：0-待售；1-在售；2-售罄。")
	@Column(name = "SELL_STATUS_")
	private String sellStatus;

	@ApiModelProperty("开工日期")
	@Column(name = "START_DATE_")
	private Date startDate;

	@ApiModelProperty("竣工日期")
	@Column(name = "END_DATE_")
	private Date endDate;

	@ApiModelProperty("开盘日期")
	@Column(name = "SELL_START_DATE_")
	private Date sellStartDate;

	@ApiModelProperty("封盘日期")
	@Column(name = "SELL_END_DATE_")
	private Date sellEndDate;

	@ApiModelProperty("交付楼栋")
	@Column(name = "COMPLETE_AREA_")
	private String completeArea;

	@ApiModelProperty("交付时间")
	@Column(name = "COMPLETE_DATE_")
	private Date completeDate;

	@ApiModelProperty("占地面积")
	@Column(name = "FLOOR_AREA_")
	private String floorArea;

	@ApiModelProperty("建筑面积")
	@Column(name = "BUILDING_AREA_")
	private String buildingArea;

	@ApiModelProperty("可售面积")
	@Column(name = "SELL_AREA_")
	private String sellArea;

	@ApiModelProperty("楼栋总数")
	@Column(name = "BUILDING_COUNT_")
	private Integer buildingCount;

	@ApiModelProperty("产权年限")
	@Column(name = "OWN_YEARS_")
	private Integer ownYears;

	@ApiModelProperty("房屋总数")
	@Column(name = "HOUSES_COUNT_")
	private Integer housesCount;

	@ApiModelProperty("装修程度")
	@Column(name = "DECORATION_LEVEL_")
	private String decorationLevel;

	@ApiModelProperty(" 绿化率")
	@Column(name = "GREEN_RATE_")
	private String greenRate;

	@ApiModelProperty("容积率")
	@Column(name = "VOLUME_RATE_")
	private String volumeRate;

	@ApiModelProperty("物业公司")
	@Column(name = "PROPERTY_COMPANY_")
	private String propertyCompany;

	@ApiModelProperty("物业类型")
	@Column(name = "PROPERTY_TYPE_")
	private String propertyType;

	@ApiModelProperty("物业管理费用。单位 元/平米/月。")
	@Column(name = "PROPERTY_PRICE")
	private Double propertyPrice;

	@ApiModelProperty("1")
	@Column(name = "COUNTVISIT_")
	private Integer countvisit;

	@ApiModelProperty("图片")
	@Column(name = "IMAGES_")
	private String images;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getSellStatus() {
		return sellStatus;
	}

	public void setSellStatus(String sellStatus) {
		this.sellStatus = sellStatus;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getSellStartDate() {
		return sellStartDate;
	}

	public void setSellStartDate(Date sellStartDate) {
		this.sellStartDate = sellStartDate;
	}

	public Date getSellEndDate() {
		return sellEndDate;
	}

	public void setSellEndDate(Date sellEndDate) {
		this.sellEndDate = sellEndDate;
	}

	public String getCompleteArea() {
		return completeArea;
	}

	public void setCompleteArea(String completeArea) {
		this.completeArea = completeArea;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
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

	public String getSellArea() {
		return sellArea;
	}

	public void setSellArea(String sellArea) {
		this.sellArea = sellArea;
	}

	public Integer getBuildingCount() {
		return buildingCount;
	}

	public void setBuildingCount(Integer buildingCount) {
		this.buildingCount = buildingCount;
	}

	public Integer getOwnYears() {
		return ownYears;
	}

	public void setOwnYears(Integer ownYears) {
		this.ownYears = ownYears;
	}

	public Integer getHousesCount() {
		return housesCount;
	}

	public void setHousesCount(Integer housesCount) {
		this.housesCount = housesCount;
	}

	public String getDecorationLevel() {
		return decorationLevel;
	}

	public void setDecorationLevel(String decorationLevel) {
		this.decorationLevel = decorationLevel;
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

	public String getPropertyCompany() {
		return propertyCompany;
	}

	public void setPropertyCompany(String propertyCompany) {
		this.propertyCompany = propertyCompany;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public Double getPropertyPrice() {
		return propertyPrice;
	}

	public void setPropertyPrice(Double propertyPrice) {
		this.propertyPrice = propertyPrice;
	}

	public Integer getCountvisit() {
		return countvisit;
	}

	public void setCountvisit(Integer countvisit) {
		this.countvisit = countvisit;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}


	
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TestAreaInfo == false) {
            return false;
        }
        if(this == obj) {
            return true;
        }
        TestAreaInfo other = (TestAreaInfo)obj;
        return new EqualsBuilder()
                .append(getId(),other.getId())
                .isEquals();
    }
}
