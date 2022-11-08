package com.pan.project.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public IPage<User> selectPageVo(IPage<?> page, User user) {
        return userMapper.selectPageVo(page, user);
    }
}
