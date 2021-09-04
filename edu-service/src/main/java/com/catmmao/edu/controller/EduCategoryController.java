package com.catmmao.edu.controller;

import java.util.List;
import javax.annotation.Resource;

import com.catmmao.utils.data.response.CommonResponse;
import com.catmmao.edu.entity.vo.CategoryAndListOfSubcategoryVo;
import com.catmmao.edu.service.EduCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 课程分类(EduCategory)表控制层
 *
 * @author catmmao
 * @since 2021-08-20 19:02:36
 */
@RestController
@CrossOrigin
@RequestMapping("/service/category")
public class EduCategoryController {
    @Resource
    private EduCategoryService eduCategoryService;

    /**
     * 获取包含子分类的分类列表
     *
     * @return 包含子分类的分类列表
     */
    @GetMapping("/all")
    public ResponseEntity<CommonResponse<List<CategoryAndListOfSubcategoryVo>>> getCategoryList() {
        List<CategoryAndListOfSubcategoryVo> data = eduCategoryService.getCategoryList();
        return ResponseEntity.ok(CommonResponse.ok(data));
    }
}

