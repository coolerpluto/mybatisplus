package com.fan.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


//@TableName("t_user")//如果实体类名和数据库表不一样，那就用这个注解进行一下绑定，因为mybatis-plus默认是根据实体类名去找数据库表的
@Data
public class User {

//    @TableId //mybatisplus默认把 id 当成主键，如果主键命名不是 `id`，那就会报错，所以需要这个注解，来表示那个属性是id
//    @TableId("uid") //如果实体类id和数据库表id不一样，那可以把数据库表id字段名赋给注解@TableId的value属性
    @TableId(value = "uid", type = IdType.AUTO)//mybatisplus的主键生成默认是遵循雪花算法，就随机生成一串数字。
//如果不设置type属性，那么无论数据库表的主键是否设置自增，表的主键值都是雪花算法生成的数字。加上这个type=IdType.AUTO，那么数据库
//    的主键就是自增的了，就不遵循雪花算法了
    public Long id;

    public String name;

    public Integer age;

    public String email;
}
