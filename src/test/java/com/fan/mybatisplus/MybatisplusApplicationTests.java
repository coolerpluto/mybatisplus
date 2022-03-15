package com.fan.mybatisplus;

import com.fan.mybatisplus.mapper.UserMapper;
import com.fan.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    UserMapper userMapper;

//    测试查询所有集合
    @Test
    void testSelectList() {
//        通过条件构造器查询一个list集合，如果没有条件，那就填入null，查询所有
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

//    测试插入数据
    @Test
    void testInsert(){
        User user = new User();
        user.setName("zhangsan");
        user.setAge(17);
        user.setEmail("zhangsan@qq.com");
        int count = userMapper.insert(user);
        System.out.println("插入数据的id："+user.getId());
    }

//    测试根据id删除
    @Test
    void testDeleteById(){
        //如果数字超出了int类型就会爆红，那就加一个L，来变成Long类型的数据
        int num = userMapper.deleteById(1503606795606691842L);
        System.out.println(num);
    }

//    测试根据map条件来删除
    @Test
    void testDeleteByMap(){
//        sql语句：Preparing: DELETE FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jone");
        map.put("age", 18);
        int num = userMapper.deleteByMap(map);
        System.out.println(num);
    }
//    测试根据多个id组成的集合来批量删除
    @Test
    void testDeleteBatchIds(){
//        因为数据库表的id使用的bigint类型，所以要用Long
//        sql语句：Preparing: DELETE FROM user WHERE id IN ( ? , ? )
        List<Long> ids = Arrays.asList(2L, 3L);
        int num = userMapper.deleteBatchIds(ids);
        System.out.println(num);
    }

//    测试自定义sql语句的查询方法，对应UserMapper xml文件
    @Test
    void testSelectMapSelfDefined(){
        Map<String, Object> map = userMapper.selectMapSelfDefined(4L);
        System.out.println(map);
    }
}
