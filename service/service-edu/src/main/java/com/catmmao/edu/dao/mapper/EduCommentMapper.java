package com.catmmao.edu.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catmmao.edu.entity.EduComment;
import org.apache.ibatis.annotations.Mapper;

/**
 * 评论(EduComment)表数据库访问层
 *
 * @author catmmao
 * @since 2021-09-17 21:07:05
 */
@Mapper
public interface EduCommentMapper extends BaseMapper<EduComment> {

}

