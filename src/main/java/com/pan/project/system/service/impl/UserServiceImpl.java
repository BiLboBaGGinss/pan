package com.pan.project.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.project.system.mapper.UserMapper;
import com.pan.project.system.domain.User;
import com.pan.project.system.service.UserService;

/**
 * @author : Pan Yanqing
 * @description :
 * @date : 2022-11-08 14:32
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Page selectPage(User user) {
        Page<User> page = Page.of(user.getCurrent(), user.getSize());
        //queryWrapper组装查询where条件
        LambdaQueryWrapper<User> queryWrapper = buildLambdaQueryWrapper(user);
        userMapper.selectPage(page, queryWrapper);
        return page;
    }

    private LambdaQueryWrapper<User> buildLambdaQueryWrapper(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        if (!"".equals(user.getName()) && user.getName() != null) {
            queryWrapper.like(User::getName, user.getName());
        }
        return queryWrapper;
    }
}
