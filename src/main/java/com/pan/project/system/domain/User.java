package com.pan.project.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author : Pan Yanqing
 * @description : 系统用户实体
 * @date : 2022-11-08 14:32
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("`user`")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "User", description = "系统用户实体")
public class User extends PageBean<User> implements Serializable {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
     * 用户名
     */
    @TableField(value = "login_name")
    @ApiModelProperty(value="用户名")
    private String loginName;

    /**
     * 名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 加密后的密码
     */
    @TableField(value = "`password`")
    @ApiModelProperty(value="加密后的密码")
    private String password;

    /**
     * 加密使用的盐
     */
    @TableField(value = "salt")
    @ApiModelProperty(value="加密使用的盐")
    private String salt;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
     * 手机号码
     */
    @TableField(value = "phone_number")
    @ApiModelProperty(value="手机号码")
    private String phoneNumber;

    /**
     * 状态，-1：逻辑删除，0：禁用，1：启用
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="状态，-1：逻辑删除，0：禁用，1：启用")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 上次登录时间
     */
    @TableField(value = "last_login_time")
    @ApiModelProperty(value="上次登录时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginTime;

    /**
     * 上次更新时间
     */
    @TableField(value = "last_update_time")
    @ApiModelProperty(value="上次更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastUpdateTime;
}