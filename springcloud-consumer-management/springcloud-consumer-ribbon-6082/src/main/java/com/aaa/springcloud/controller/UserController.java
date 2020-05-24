package com.aaa.springcloud.controller;

import com.aaa.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 使用restTemplate实现调用
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    public static final String URL = "http://USER-PROVIDER";

    //脱离eureka 的配置
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/userAll")
    public List<User> selectAllUsers() {
        //restTemplate的get请求                                       接收的数据类型
       return restTemplate.getForObject(URL+"/userAll",List.class);
    }


    //脱离eureka  application.properties的localhost会报错
    //需要 花生壳 解决 路径映射问题
    @RequestMapping("/balanceAllUsers")
    public List<User> selectUserByLoadBalance(){
        //1.通过loadBalancerClient对象获取所有服务提供的信息  application.properties中
        ServiceInstance serviceInstance = loadBalancerClient.choose("user-provider");
       //获取ip和端口号
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        return restTemplate.getForObject("http://"+host+":"+port+"/userAll",List.class);
    }
}
