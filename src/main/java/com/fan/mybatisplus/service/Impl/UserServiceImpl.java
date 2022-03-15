package com.fan.mybatisplus.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.mybatisplus.mapper.UserMapper;
import com.fan.mybatisplus.pojo.User;
import com.fan.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

//自定义的service实现类首先需要实现自定义的接口，然后需要继承ServiceImpl来实现这些接口方法，需要注意ServiceImpl
//写上实体mapper方法和实体类名
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
