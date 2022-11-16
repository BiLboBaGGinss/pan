package com.pan.framework.config.web.handler;

import cn.dev33.satoken.stp.StpUtil;
import com.pan.project.system.domain.result.Result;
import com.pan.project.system.domain.result.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Pan Yanqing
 * @description : 全局异常处理
 * @date : 2022-11-16 16:12
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(HttpServletRequest request, Exception exception){
        if (StpUtil.isLogin()){
            return Result.error(ResultCode.FAILED.getCode(), "服务器内部错误");
        }else{
            return Result.error(ResultCode.USER_TOKEN_INVALID.getCode(), ResultCode.USER_TOKEN_INVALID.getMsg());
        }

    }
}
