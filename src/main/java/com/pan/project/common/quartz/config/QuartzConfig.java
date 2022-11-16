package com.pan.project.common.quartz.config;

import cn.hutool.log.LogFactory;
import com.pan.project.common.quartz.job.TestJob;
import org.quartz.*;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 定义任务描述和具体的执行时间
 */
@Configuration
public class QuartzConfig {

    private String cron = "0/5 * * * * ? ";

    @Bean
    public JobDetail jobDetail() {
        //指定任务描述具体的实现类
        return JobBuilder.newJob(TestJob.class)
                // 指定任务的名称
                .withIdentity("testJob")
                // 任务描述
                .withDescription("任务描述：用于测试")
                // 每次任务执行后进行存储
                .storeDurably()
                .build();
    }

    @Bean
    public CronTrigger trigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail())
                .withIdentity("testJob")
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
