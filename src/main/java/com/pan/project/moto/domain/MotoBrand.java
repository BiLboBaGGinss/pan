package com.pan.project.moto.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author : Pan Yanqing
 * @description : 
 * @date : 2022-11-18 13:09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("moto_brand")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "MotoBrand", description = "摩托品牌")
public class MotoBrand {
    /**
     * ID 
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="ID ")
    private Long id;

    @TableField(value = "ad_model")
    @ApiModelProperty(value="")
    private String adModel;

    /**
     * 首字母
     */
    @TableField(value = "aleph")
    @ApiModelProperty(value="首字母")
    private String aleph;

    /**
     * authStatus
     */
    @TableField(value = "auth_status")
    @ApiModelProperty(value="authStatus")
    private String authStatus;

    /**
     * 开始时间
     */
    @TableField(value = "begin_time")
    @ApiModelProperty(value="开始时间")
    private Date beginTime;

    /**
     * 品牌描述
     */
    @TableField(value = "brand_desc")
    @ApiModelProperty(value="品牌描述")
    private String brandDesc;

    /**
     * 品牌能源类型
     */
    @TableField(value = "brand_energy_type")
    @ApiModelProperty(value="品牌能源类型")
    private Integer brandEnergyType;

    /**
     * 品牌ID
     */
    @TableField(value = "brand_id")
    @ApiModelProperty(value="品牌ID")
    private Long brandId;

    /**
     * 品牌Logo
     */
    @TableField(value = "brand_logo")
    @ApiModelProperty(value="品牌Logo")
    private String brandLogo;

    /**
     * 品牌名称
     */
    @TableField(value = "brand_name")
    @ApiModelProperty(value="品牌名称")
    private String brandName;

    /**
     * 结束时间
     */
    @TableField(value = "end_time")
    @ApiModelProperty(value="结束时间")
    private Date endTime;

    /**
     * existSaleGoods
     */
    @TableField(value = "exist_sale_goods")
    @ApiModelProperty(value="existSaleGoods")
    private Integer existSaleGoods;

    /**
     * expireAuth
     */
    @TableField(value = "expire_auth")
    @ApiModelProperty(value="expireAuth")
    private String expireAuth;

    /**
     * goodsCount
     */
    @TableField(value = "goods_count")
    @ApiModelProperty(value="goodsCount")
    private Integer goodsCount;

    /**
     * 关键词
     */
    @TableField(value = "keywords")
    @ApiModelProperty(value="关键词")
    private String keywords;

    /**
     * mobile
     */
    @TableField(value = "mobile")
    @ApiModelProperty(value="mobile")
    private String mobile;

    /**
     * newCarThirdPartyLink
     */
    @TableField(value = "new_car_third_party_link")
    @ApiModelProperty(value="newCarThirdPartyLink")
    private String newCarThirdPartyLink;

    /**
     * productType
     */
    @TableField(value = "product_type")
    @ApiModelProperty(value="productType")
    private String productType;

    /**
     * shopId
     */
    @TableField(value = "shop_id")
    @ApiModelProperty(value="shopId")
    private Integer shopId;

    /**
     * 排序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 拼音
     */
    @TableField(value = "spelling")
    @ApiModelProperty(value="拼音")
    private String spelling;

    /**
     * 状态
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="状态")
    private Integer status;

    /**
     * 标签
     */
    @TableField(value = "tag")
    @ApiModelProperty(value="标签")
    private String tag;

    /**
     * 库存紧张
     */
    @TableField(value = "tight_stock")
    @ApiModelProperty(value="库存紧张")
    private Integer tightStock;

    /**
     * tradeIsValid
     */
    @TableField(value = "trade_is_valid")
    @ApiModelProperty(value="tradeIsValid")
    private Integer tradeIsValid;

    /**
     * tradeValid
     */
    @TableField(value = "trade_valid")
    @ApiModelProperty(value="tradeValid")
    private Integer tradeValid;

    /**
     * 创建来源
     */
    @TableField(value = "create_by")
    @ApiModelProperty(value="创建来源")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 更新来源
     */
    @TableField(value = "update_by")
    @ApiModelProperty(value="更新来源")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;
}