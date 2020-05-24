package com.aaa.springcloud.fallback;

import com.aaa.springcloud.model.User;
import com.aaa.springcloud.service.IUserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/9/29 10:36
 * @Description
 *      @Component和@Service的区别
 *      @Autowired和@Resource的区别
 **/
@Component
public class IUserServiceFallbackFactory implements FallbackFactory<IUserService> {


    public IUserService create(Throwable throwable) {
        return new IUserService() {
            public List<User> selectAllUsers() {
                System.out.println("测试熔断");
                return null;
            }
        };
    }
}

