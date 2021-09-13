package com.catmmao.edu.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catmmao.edu.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表(User)表数据库访问层
 *
 * @author catmmao
 * @since 2021-09-13 17:16:22
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

