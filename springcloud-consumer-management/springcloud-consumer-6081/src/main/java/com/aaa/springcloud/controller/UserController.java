package com.aaa.springcloud.controller;

import com.aaa.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 使用restTemplate实现调用
 */
@RestController
public class UserController {

    //config配置得到
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/userAll")
    public List<User> selectAllUsers() {
        //restTemplate的get请求                                       接收的数据类型
       return restTemplate.getForObject("http://localhost:8081/userAll",List.class);
    }

}
