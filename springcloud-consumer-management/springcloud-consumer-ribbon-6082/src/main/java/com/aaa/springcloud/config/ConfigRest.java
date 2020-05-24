package com.aaa.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigRest {
    @Bean
    @LoadBalanced   //开启ribbon
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
////定义ribbon规则
//    @Bean
//    public IRule randoms(){
//        return new RandomRule();
//    }
}
