package com.aaa.springcloud.service;

import com.aaa.springcloud.mapper.UserMapper;
import com.aaa.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/9/26 9:13
 * @Description
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> selectAllUsers() {
        return userMapper.selectAll();
    }

}
