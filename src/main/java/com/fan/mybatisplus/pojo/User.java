package com.fan.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


//@TableName("t_user")//如果实体类名和数据库表不一样，那就用这个注解进行一下绑定，因为mybatis-plus默认是根据实体类名去找数据库表的
@Data
public class User {

    @TableField //mybatisplus默认把 id 当成主键，如果主键不是 `id`，那就会报错，所以需要这个注解，来表示那个属性是id
    //@TableField("uid") //如果实体类id和数据库表id不一样，那可以把数据库表id字段名赋给注解@TableField的value属性
    public Long uid;

    public String name;

    public Integer age;

    public String email;
}
