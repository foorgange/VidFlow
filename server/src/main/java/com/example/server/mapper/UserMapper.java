package com.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.server.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
/** users 表数据访问接口（MyBatis-Plus 基础 CRUD）。 */
public interface UserMapper extends BaseMapper<User> {
    //MyBatis-Plus自动搞定增删改查
}