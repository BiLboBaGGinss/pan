package com.pan.project.system.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.project.system.domain.Role;
import com.pan.project.system.mapper.RoleMapper;
import com.pan.project.system.service.RoleService;
/**
 * @author : Pan Yanqing
 * @description : 
 * @date : 2022-11-08 14:32
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService{

}
