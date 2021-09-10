package com.catmmao.edu.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catmmao.edu.dao.mapper.CrmBannerMapper;
import com.catmmao.edu.entity.CrmBanner;
import com.catmmao.edu.service.CrmBannerService;
import org.springframework.stereotype.Service;

/**
 * 首页banner(CrmBanner)表服务实现类
 *
 * @author catmmao
 * @since 2021-09-09 21:03:29
 */
@Service("crmBannerService")
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {

    @Override
    public List<CrmBanner> getFrontIndexBannerList() {

        QueryWrapper<CrmBanner> wrapper = new QueryWrapper<>();
        wrapper.last("limit 2");
        return this.list(wrapper);
    }
}