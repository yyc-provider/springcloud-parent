package com.aaa.springcloud.service;


import com.aaa.springcloud.fallback.IUserServiceFallbackFactory;
import com.aaa.springcloud.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**

 *      其实就是通过这个IUserService接口去映射Provider项目的controller
 *          feign其实也是实现了负载均衡("USER-PROVIDER")
 *      @FeignClient(value = "USER-PROVIDER")--->映射到了eureka中的provider(三台)
 *          假如provider中有10个方法，IUserService也有10个方法，如何确定provider controller中的方法
 *          和IUserService中方法进行映射呢？
 *
 *       注意：
 *          FeignClient注解中的value值必须是eureka中的Application的值
 *          IUserService接口中RequestMapping注解的值必须要和provider中controller的RequestMapping注解的值保持一致
 *
 *
 *
 *         如果需要传参
 *              如果参数为基本类型则需要使用@RequestParam标识
 *              无论是在IUserService的接口中还是在provider的controller的方法中都必须要添加这个注解
 *
 *              如果参数为包装类型(实体类,Integer....)
 *              就必须使用 @RequestBody 进行标识
 *              并且实体类必须要实现序列化接口(要用流的形式传输)
 *
 *          接口和provider的controller所传递的参数类型和参数数量也必须保持一致
 *          (Springcloud2.x)
 *              !!!!!!!!!!!只能传一个参数，如果需要传递多个参数自己封装!!!!!!!!!!!
 **/
@FeignClient(value = "USER-PROVIDER",fallbackFactory = IUserServiceFallbackFactory.class)
public interface IUserService {

    @RequestMapping("/userAll")
    List<User> selectAllUsers();

}
