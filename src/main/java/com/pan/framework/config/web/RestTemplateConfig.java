package com.pan.framework.config.web;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author : Pan Yanqing
 * @description :
 * @date : 2022-11-18 12:58
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @ConditionalOnMissingBean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(10000);
        requestFactory.setReadTimeout(10000);
        return new RestTemplate(requestFactory);
    }
    
}
