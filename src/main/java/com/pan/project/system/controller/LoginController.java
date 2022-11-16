package com.pan.project.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pan.project.system.domain.User;
import com.pan.project.system.domain.result.Result;
import com.pan.project.system.domain.result.ResultCode;
import com.pan.project.system.service.UserService;
import com.pan.project.common.utils.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author : Pan Yanqing
 * @description : 登录控制器
 * @date : 2022-11-09 8:50
 */
@RestController
@RequestMapping("/")
@Slf4j
@Api(tags = "登录退出相关接口")
public class LoginController {
    @Resource
    private UserService userService;

    /**
     * 登录
     * @param loginName
     * @param password
     * @return
     */
    @PostMapping("login")
    @ApiOperation("登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginName", value = "登录账号", required = true),
            @ApiImplicitParam(name = "password", value = "登录密码", required = true)
    })
    public Result login(String loginName, String password) {
        // 查询用户
        User user = userService.getOne(new QueryWrapper<User>().eq("login_name", loginName).eq("status", 1));
        if (user == null) {
            return Result.error(ResultCode.USER_LOGIN_ERROR.getCode(), ResultCode.USER_LOGIN_ERROR.getMsg());
        }
        if (MD5Util.inputPassToFromPass(password, user.getSalt()).equals(user.getPassword())) {
            StpUtil.login(user.getId());
            user.setLastLoginTime(new Date()).setTokenInfo(StpUtil.getTokenInfo());
            userService.updateById(user);
            StpUtil.getSession().set("user", user);
            return Result.success(user);
        }else{
            return Result.error(ResultCode.USER_LOGIN_ERROR.getCode(), ResultCode.USER_LOGIN_ERROR.getMsg());
        }
    }

    /**
     * 查询 Token 信息
     * @return
     */
    @PostMapping("tokenInfo")
    @ApiOperation("查询Token信息")
    public Result tokenInfo() {
        if (StpUtil.isLogin()){
            return Result.success(StpUtil.getTokenInfo());
        }else{
            return Result.error(ResultCode.USER_NOT_LOGIN.getCode(), ResultCode.USER_NOT_LOGIN.getMsg());
        }
    }

    /**
     * 退出
     * @return
     */
    @PostMapping("logout")
    @ApiOperation("退出")
    public Result logout() {
        StpUtil.logout(StpUtil.getLoginId());
        return Result.success();
    }
}
