package com.pan.project.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pan.project.system.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
    /**
 * @author : Pan Yanqing
 * @description : 
 * @date : 2022-11-08 14:32
 */
public interface UserService extends IService<User>{

        IPage<User> selectPageVo(IPage<?> page, User user);

}
