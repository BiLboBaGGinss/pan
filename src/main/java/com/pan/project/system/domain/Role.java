package com.pan.project.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Pan Yanqing
 * @description : 
 * @date : 2022-11-08 14:32
 */
/**
    * 角色表
    */
@ApiModel(value="角色表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`role`")
public class Role {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
     * 角色名
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value="角色名")
    private String name;
}