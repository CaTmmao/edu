package com.catmmao.edu.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catmmao.edu.entity.EduOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单(EduOrder)表数据库访问层
 *
 * @author catmmao
 * @since 2021-09-19 19:01:19
 */
@Mapper
public interface EduOrderMapper extends BaseMapper<EduOrder> {

}

