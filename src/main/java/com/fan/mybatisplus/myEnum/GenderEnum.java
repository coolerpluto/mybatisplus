package com.fan.mybatisplus.myEnum;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

//性别枚举类，定义好这个类之后还需在配置文件设置枚举扫描包
@Getter
public enum GenderEnum {

    MALE(1,"男"),
    FEMALE(2,"女");

    @EnumValue//这个注解放在gender上面表示在调用GenderEnum.MALE往数据库表放的是gender Integer数据
//    性别数字
    private Integer gender;
//    性别名称
    private String genderName;

    GenderEnum(Integer gender, String genderName) {
        this.gender = gender;
        this.genderName = genderName;
    }
}
