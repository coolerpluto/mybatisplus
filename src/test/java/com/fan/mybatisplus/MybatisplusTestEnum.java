package com.fan.mybatisplus;

import com.fan.mybatisplus.mapper.UserMapper;
import com.fan.mybatisplus.myEnum.GenderEnum;
import com.fan.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisplusTestEnum {

    @Autowired
    UserMapper userMapper;

//    测试枚举
    @Test
    void testGenderEnum(){
        User user = new User();
        user.setName("小吴");
        user.setAge(20);
        user.setEmail("xiaowu@qq.com");
//        直接调用枚举类定义的枚举匹配
        user.setGender(GenderEnum.MALE);
        int insert = userMapper.insert(user);
        System.out.println("insert:"+insert);
    }
}
