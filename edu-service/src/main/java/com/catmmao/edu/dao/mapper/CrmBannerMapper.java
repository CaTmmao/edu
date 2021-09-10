package com.catmmao.edu.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catmmao.edu.entity.CrmBanner;
import org.apache.ibatis.annotations.Mapper;

/**
 * 首页banner(CrmBanner)表数据库访问层
 *
 * @author catmmao
 * @since 2021-09-09 21:03:28
 */
@Mapper
public interface CrmBannerMapper extends BaseMapper<CrmBanner> {

}

