package com.pan.project.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pan.project.system.domain.User;
import com.pan.project.system.service.UserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : Pan Yanqing
 * @description :
 * @date : 2022-11-08 15:30
 */
@RestController
@RequestMapping("/system/")
@Slf4j
@Api(tags = "用户相关接口")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/toList")
    @ApiOperation("查询用户列表")
    @ApiImplicitParams(@ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "User"))
    public IPage<User> toList(@RequestBody User user){
        return userService.selectPageVo(new Page<>(user.getPage(),user.getSize()), user);
    }
}
