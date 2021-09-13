package com.catmmao.edu.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catmmao.edu.entity.CrmBanner;
import org.springframework.stereotype.Service;

/**
 * 首页banner(CrmBanner)表服务接口
 *
 * @author catmmao
 * @since 2021-09-09 21:03:29
 */
@Service
public interface CrmBannerService extends IService<CrmBanner> {

    /**
     * 获取网站首页banner列表(返回两条数据)
     *
     * @return banner列表
     */
    List<CrmBanner> getFrontIndexBannerList();
}

