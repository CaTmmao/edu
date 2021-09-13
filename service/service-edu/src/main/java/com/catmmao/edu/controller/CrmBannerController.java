package com.catmmao.edu.controller;

import java.util.List;
import javax.annotation.Resource;

import com.catmmao.edu.entity.CrmBanner;
import com.catmmao.edu.service.CrmBannerService;
import com.catmmao.utils.data.response.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页banner(CrmBanner)表控制层
 *
 * @author catmmao
 * @since 2021-09-09 21:03:28
 */
@RestController
@CrossOrigin
@RequestMapping("/service/banner")
public class CrmBannerController {

    @Resource
    private CrmBannerService crmBannerService;

    /**
     * 获取网站首页banner列表(返回两条数据)
     *
     * @return banner列表
     */
    @GetMapping("/front/index/list")
    public ResponseEntity<CommonResponse<List<CrmBanner>>> getFrontIndexBannerList() {

        List<CrmBanner> data = crmBannerService.getFrontIndexBannerList();
        return ResponseEntity.ok(CommonResponse.ok(data));
    }
}

