package com.pan.project.moto.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.project.moto.mapper.MotoBrandMapper;
import com.pan.project.moto.domain.MotoBrand;
import com.pan.project.moto.service.MotoBrandService;
/**
 * @author : Pan Yanqing
 * @description : 
 * @date : 2022-11-18 13:09
 */
@Service
@DS("moto")
public class MotoBrandServiceImpl extends ServiceImpl<MotoBrandMapper, MotoBrand> implements MotoBrandService{

}
