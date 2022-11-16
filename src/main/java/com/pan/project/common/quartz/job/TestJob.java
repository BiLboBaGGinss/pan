package com.pan.project.common.quartz.job;

import cn.hutool.log.Log;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TestJob extends QuartzJobBean {

    private final Log log = Log.get(QuartzJobBean.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("测试定时任务罢了");
    }
}
