package com.pan.project.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author : Pan Yanqing
 * @description :
 * @date : 2022-11-17 14:17
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TestJob {
    @XxlJob("xxlJobTest")
    public ReturnT<String> xxlJobTest(String date) {
        log.info("---------xxlJobTest定时任务执行成功--------");
        return ReturnT.SUCCESS;
    }
}
