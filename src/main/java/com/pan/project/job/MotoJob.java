package com.pan.project.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pan.project.moto.domain.MotoBrand;
import com.pan.project.moto.service.MotoBrandService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Pan Yanqing
 * @description :
 * @date : 2022-11-18 12:56
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MotoJob {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MotoBrandService motoBrandService;

    @XxlJob("motoBrandUpdate")
    public ReturnT<String> motoBrandUpdate() {
        //返回 response 可通过此拿到 responseHeader ， 通过response.getBody()拿到 User对象
        ResponseEntity<JSONObject> response = restTemplate.getForEntity("https://api.58moto.com/carport/brand/v2/all/list", JSONObject.class);
        JSONObject res = response.getBody();
        JSONArray dataAry = res.getJSONArray("data");
        List<MotoBrand> brandList = JSONObject.parseArray(dataAry.toJSONString(), MotoBrand.class);
        List<MotoBrand> addBrandList = new ArrayList<>();
        List<MotoBrand> updateBrandList = new ArrayList<>();
        for (MotoBrand motoBrand : brandList) {
            MotoBrand m = motoBrandService.getOne(new QueryWrapper<MotoBrand>().eq("brand_id", motoBrand.getBrandId()));
            if (m != null){
                motoBrand.setId(m.getId());
                updateBrandList.add(motoBrand);
            }else{
                addBrandList.add(motoBrand);
            }
        }
        if (updateBrandList.size() > 0){
            motoBrandService.updateBatchById(updateBrandList);
        }
        if (addBrandList.size() > 0){
            motoBrandService.saveBatch(addBrandList);
        }
        return ReturnT.SUCCESS;
    }

}
