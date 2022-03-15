package com.fan.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fan.mybatisplus.pojo.User;

//IService 封装了各种接口，然后让自定义的service接口去继承，需要注意在IService写上泛型要操作的实体类
public interface UserService extends IService<User> {
}
