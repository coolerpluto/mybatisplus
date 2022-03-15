package com.fan.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fan.mybatisplus.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {
    Map<String, Object> selectMapSelfDefined(Long id);
}
