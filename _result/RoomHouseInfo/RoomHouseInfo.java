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
@Table(name = "room_house_info")
public class RoomHouseInfo extends BasePO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty("主键")
	@Column(name = "ID_")
	private String id;

	@ApiModelProperty("楼ID")
	@Column(name = "BUILDING_ID_")
	private String buildingId;

	@ApiModelProperty("户型ID")
	@Column(name = "HOUSE_TYPE_ID_")
	private String houseTypeId;

	@ApiModelProperty("房号")
	@Column(name = "HOUSE_CODE_")
	private String houseCode;

	@ApiModelProperty("房源名称")
	@Column(name = "HOUSE_NAME_")
	private String houseName;

	@ApiModelProperty("展示名称")
	@Column(name = "DISPLAY_NAME_")
	private String displayName;

	@ApiModelProperty("所属单元")
	@Column(name = "LABEL_TYPE_")
	private Integer labelType;

	@ApiModelProperty("楼层")
	@Column(name = "LABEL_")
	private String label;

	@ApiModelProperty("总售价")
	@Column(name = "TOTAL_PRICE_")
	private Double totalPrice;

	@ApiModelProperty("单价")
	@Column(name = "UNIT_PRICE_")
	private Double unitPrice;

	@ApiModelProperty("装修程度")
	@Column(name = "DECORATION_LEVEL_")
	private String decorationLevel;

	@ApiModelProperty("描述")
	@Column(name = "DECORATION_")
	private String decoration;

	@ApiModelProperty("图片")
	@Column(name = "IMAGES_")
	private String images;

	@ApiModelProperty("售卖状态。0-待售；1-线上销售；2-在售；3-已售。")
	@Column(name = "SELL_STATUS_")
	private String sellStatus;

	@ApiModelProperty("权属：商品房")
	@Column(name = "OWNER_TYPE")
	private String ownerType;

	@ApiModelProperty("用途")
	@Column(name = "USE_TYPE_")
	private String useType;

	@ApiModelProperty("朝向")
	@Column(name = "TOWARDS_")
	private String towards;

	@ApiModelProperty("交付时间")
	@Column(name = "COMPLETE_DATE_")
	private Date completeDate;

	@ApiModelProperty("入住时间")
	@Column(name = "LIVE_DATE_")
	private Date liveDate;

	@ApiModelProperty("标签")
	@Column(name = "TAGS_")
	private String tags;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getHouseTypeId() {
		return houseTypeId;
	}

	public void setHouseTypeId(String houseTypeId) {
		this.houseTypeId = houseTypeId;
	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getLabelType() {
		return labelType;
	}

	public void setLabelType(Integer labelType) {
		this.labelType = labelType;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDecorationLevel() {
		return decorationLevel;
	}

	public void setDecorationLevel(String decorationLevel) {
		this.decorationLevel = decorationLevel;
	}

	public String getDecoration() {
		return decoration;
	}

	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getSellStatus() {
		return sellStatus;
	}

	public void setSellStatus(String sellStatus) {
		this.sellStatus = sellStatus;
	}

	public String getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	public String getUseType() {
		return useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	public String getTowards() {
		return towards;
	}

	public void setTowards(String towards) {
		this.towards = towards;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public Date getLiveDate() {
		return liveDate;
	}

	public void setLiveDate(Date liveDate) {
		this.liveDate = liveDate;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}


	
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RoomHouseInfo == false) {
            return false;
        }
        if(this == obj) {
            return true;
        }
        RoomHouseInfo other = (RoomHouseInfo)obj;
        return new EqualsBuilder()
                .append(getId(),other.getId())
                .isEquals();
    }
}
