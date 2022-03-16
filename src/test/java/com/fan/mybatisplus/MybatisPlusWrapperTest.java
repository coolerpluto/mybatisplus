package com.fan.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fan.mybatisplus.mapper.UserMapper;
import com.fan.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusWrapperTest {

    @Autowired
    UserMapper userMapper;

//    模糊、范围之间、不为空条件
    @Test
    void testQueryWrapper(){
//        查询用户名包含a，年龄在20到20之间，邮箱信息不为null的用户信息
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        条件构造器就是一个封装目标数据的对象，要哪些数据不要哪些数据，进行链式添加条件，然后把这个构造器放到mapper的方法参数上
        userQueryWrapper.like("user_name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
    }

//    排序条件
    @Test
    void testQueryWrapperOderBy(){
//        查询用户信息，按照年龄降序排序，若年龄相同，则按照id升序排序
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.orderByDesc("age")
                .orderByAsc("uid");
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
    }

//    或者条件
    @Test
    void testQueryWrapperUpdate(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        将（年龄大于20并且姓名包含a）或者邮箱为null的用户信息修改
        userQueryWrapper.gt("age", 20)
                .like("user_name", "a")
                .or()
                .isNull("email");
        User user = new User();
        user.setAge(10);
        user.setEmail("abc@qq.com");
//        这个update里的QueryWrapper是用来查询符合上述条件的数据，然后用user实体类来进行修改
        int update = userMapper.update(user, userQueryWrapper);
        System.out.println("update:"+update);
    }

//    测试优先级条件
    @Test
    void test01(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        将用户名包含有a并且（年龄大于20或者邮箱为null）的用户信息修改
//        and里面可以继续添加wrapper条件构造器
        userQueryWrapper.like("user_name", "a")
                .and(i->i.gt("age", 20).or().isNull("email"));
        User user = new User();
        user.setName("奋斗");
        user.setAge(10);
        int update = userMapper.update(user, userQueryWrapper);
        System.out.println("update:"+update);
    }


//    查询指定字段的数据
    @Test
    void test02(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("user_name", "age", "email");//指定好要查询哪些字段
        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);
        maps.forEach(System.out::println);
//==>  Preparing: SELECT user_name,age,email FROM t_user WHERE is_deleted=0
//==> Parameters:
//<==    Columns: user_name, age, email
//<==        Row: Jone, 18, test1@baomidou.com
//<==        Row: Jack, 20, test2@baomidou.com
//<==        Row: Tom, 20, test3@baomidou.com
//<==        Row: 奋斗, 10, abc@qq.com
//<==        Row: 奋斗, 10, null
//<==      Total: 5
    }


//    测试UpdateWrapper
    @Test
    void testUpdateWrapper(){
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        //        将用户名包含有a并且（年龄大于20或者邮箱为null）的用户信息修改
//        先把UpdateQueryMapper条件构造器定义好筛选条件
        userUpdateWrapper.like("user_name", "a")
                .and(i->i.gt("age", 20).or().isNull("email"));
//        然后把要修改的字段和值set一下
        userUpdateWrapper.set("user_name", "小王").set("age", 19);
//        因为update放条件构造器必须要设置个实体，所以就放null
        int update = userMapper.update(null, userUpdateWrapper);
        System.out.println("update:"+update);
    }


//    条件构造器的方法参数都会有一个布尔值判断，通常用于判断条件是否添加，比如如果姓名为空，那就不增加判断姓名是否包含a的条件
//    节省了不用if语句判断姓名是否为空然后再增加这个条件的繁琐步骤
    @Test
    void testCondition(){
        String userName = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like(StringUtils.isNotBlank(userName), "user_name", userName)
                .ge(ageBegin!=null, "age", ageBegin)
                .le(ageEnd!=null, "age", ageEnd);
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
    }



//    LambdaQueryWrapper可以不用手写数据库表字段名，直接调用实体类get方法来获取属性所对应的字段名
    @Test
    void testLambdaQueryWrapper(){
        String userName = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.like(StringUtils.isNotBlank(userName), User::getName, userName)
                .ge(ageBegin!=null, User::getAge, ageBegin)
                .le(ageEnd!=null, User::getAge, ageEnd);
        List<User> users = userMapper.selectList(userLambdaQueryWrapper);
        users.forEach(System.out::println);
    }
}
