package com.fan.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fan.mybatisplus.myEnum.GenderEnum;
import lombok.Data;


//@TableName("t_user")//如果实体类名和数据库表不一样，那就用这个注解进行一下绑定，因为mybatis-plus默认是根据实体类名去找数据库表的
@Data
public class User {

//    @TableId //mybatisplus默认把 id 当成主键，如果主键命名不是 `id`，那就会报错，所以需要这个注解，来表示那个属性是id
//    @TableId("uid") //如果实体类id和数据库表id不一样，那可以把数据库表id字段名赋给注解@TableId的value属性
    @TableId(value = "uid", type = IdType.AUTO)//mybatisplus的主键生成默认是遵循雪花算法，就随机生成一串数字。
//如果不设置type属性，那么无论数据库表的主键是否设置自增，表的主键值都是雪花算法生成的数字。加上这个type=IdType.AUTO，那么数据库
//    的主键就是自增的了，就不遵循雪花算法了
    private Long id;


//    指定属性所对应的表字段名称
    @TableField("user_name")
    private String name;

    private Integer age;

    private String email;

    @TableLogic
    private Integer isDeleted;//逻辑删除：0代表未删除，1代表已删除，测试类MybatisplusApplicationTests里有示例

    private GenderEnum gender;
}
