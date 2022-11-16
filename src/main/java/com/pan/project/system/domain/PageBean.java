package com.pan.project.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 分页返回信息插件
 *
 * @author MYM_ZUOYAN
 * @date 2021/3/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "PageBean", description = "分页返回信息插件实体")
public class PageBean<T> implements Serializable {
    private static final Long serialVersionUID = 1L;

    /**
     * 当前页
     */
    @ApiModelProperty("当前页")
    @TableField(exist = false)
    private Integer current;

    /**
     * 查询长度
     */
    @ApiModelProperty("查询长度")
    @TableField(exist = false)
    private Integer size;

}
