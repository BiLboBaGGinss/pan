package com.pan.project.system.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pan.project.system.domain.User;
import com.pan.project.system.domain.result.Result;
import com.pan.project.system.domain.result.ResultCode;
import com.pan.project.system.service.UserService;
import com.pan.common.utils.MD5Util;
import com.pan.common.utils.SaltUtils;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author : Pan Yanqing
 * @description :
 * @date : 2022-11-08 15:30
 */
@RestController
@RequestMapping("/system/")
@Slf4j
@Api(tags = "用户相关接口")
@SaCheckLogin
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/toList")
    @ApiOperation("查询用户列表")
    @ApiImplicitParams(@ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "User"))
    public Result toList(@RequestBody User user) {
        return Result.success(userService.selectPage(user));
    }

    @PostMapping("/toAdd")
    @ApiOperation("新增用户")
    @ApiImplicitParams(@ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "User"))
    public Result toAdd(@RequestBody User user) {
        if (user == null) {
            return Result.error(ResultCode.PARAM_IS_BLANK.getCode(), ResultCode.PARAM_IS_BLANK.getMsg());
        }
        //判重
        User u = userService.getOne(new QueryWrapper<User>().eq("login_name", user.getLoginName()));
        if (u != null) {
            return Result.error(ResultCode.REPEAT_USER_LOGINNAME.getCode(), ResultCode.REPEAT_USER_LOGINNAME.getMsg());
        }
        //生产盐字符串
        String salt = SaltUtils.getsalt(10);
        user.setPassword(MD5Util.inputPassToFromPass(user.getPassword(), salt)).setSalt(salt).setCreateTime(new Date());
        if (userService.save(user)){
            return Result.success();
        }else{
            return Result.error();
        }
    }
}
