package com.fan.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {
    Map<String, Object> selectMapSelfDefined(Long id);

//    使用自定义sql与语句查询的数据来实现分页，第一个参数放已设置页码和页数据大小的page对象，，第二个放参数
//    方法返回值还是page类，然后mapper xml文件里sql语句无需关心page，只需查询好数据
    Page<User> selectPageUseSql(@Param("page") Page<User> page, @Param("age") Integer age);

}
