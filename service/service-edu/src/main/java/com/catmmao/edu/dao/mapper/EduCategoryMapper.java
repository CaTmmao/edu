package com.catmmao.edu.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catmmao.edu.entity.EduCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程分类(EduCategory)表数据库访问层
 *
 * @author catmmao
 * @since 2021-08-20 19:02:36
 */
@Mapper
public interface EduCategoryMapper extends BaseMapper<EduCategory> {

}

