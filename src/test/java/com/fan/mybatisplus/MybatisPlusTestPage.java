package com.fan.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.mybatisplus.mapper.UserMapper;
import com.fan.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusTestPage {
    @Autowired
    UserMapper userMapper;


    @Test
    void testPage01(){
//        Page类是mybatisplus专门用于分页的类
//        public Page(long current, long size)，current是指当前页码，size是一页的数据个数
        Page<User> userPage = new Page<>(2,3);
//        不添加条件构造器代表查询所有数据的分页情况
        userMapper.selectPage(userPage, null);
        System.out.println(userPage);
    }

    @Test
    void testPageUseSql(){
        Page<User> userPage = new Page<>(1,3);
        userMapper.selectPageUseSql(userPage, 20);
//        此时page就是已分页好的分页对象，可以调用getRecords来获取分页数据
        List<User> users = userPage.getRecords();
        users.forEach(System.out::println);
    }
}
