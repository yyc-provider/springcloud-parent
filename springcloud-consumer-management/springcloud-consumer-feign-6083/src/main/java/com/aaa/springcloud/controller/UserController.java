package com.aaa.springcloud.controller;

import com.aaa.lee.springcloud.model.User;
import com.aaa.lee.springcloud.service.IUserService;
import com.aaa.springcloud.service.IUserService;
import com.aaa.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/userAll")
    public List<User> selectAllUsers() {
        return userService.selectAllUsers();
    }

}
