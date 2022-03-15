package com.fan.mybatisplus;

import com.fan.mybatisplus.pojo.User;
import com.fan.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MybatisplusTestService {

    @Autowired
    private UserService userService;
//测试service获取数据个数
    @Test
    void testService(){
        long num = userService.count();
        System.out.println(num);
    }

//    测试service批量添加
    @Test
    void testSaveBatch(){
        List<User> users = new ArrayList<>();
        for (int i =10; i < 20; i++){
            User user = new User();
            user.setName("测试"+i);
            user.setAge(i);
            user.setEmail(i+"@qq.com");
            users.add(user);
        }
        boolean result = userService.saveBatch(users);
        System.out.println(result);
    }
}
