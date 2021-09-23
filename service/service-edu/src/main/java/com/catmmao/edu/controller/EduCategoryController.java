package com.catmmao.edu.controller;

import java.util.List;
import javax.annotation.Resource;

import com.catmmao.edu.entity.EduCategory;
import com.catmmao.edu.entity.vo.CategoryAndListOfSubcategoryVo;
import com.catmmao.edu.service.EduCategoryService;
import com.catmmao.utils.data.response.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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


    /**
     * 根据分类ID获取分类信息
     *
     * @param id 分类ID
     * @return 分类信息
     */
    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<EduCategory>> getCategoryById(@PathVariable String id) {
        EduCategory data = eduCategoryService.getCategoryById(id);
        return ResponseEntity.ok(CommonResponse.ok(data));
    }

    /**
     * 添加分类
     *
     * @param category 分类信息
     * @return 是否添加成功
     */
    @PostMapping
    public ResponseEntity<CommonResponse<?>> createCategory(@RequestBody EduCategory category) {
        eduCategoryService.createCategory(category);
        return ResponseEntity.ok(CommonResponse.ok(true));
    }

    /**
     * 删除分类
     *
     * @param id 分类ID
     * @return 是否删除成功
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<Boolean>> deleteCategory(@PathVariable String id) {
        eduCategoryService.deleteCategory(id);
        return ResponseEntity.ok(CommonResponse.ok(true));
    }

    /**
     * 更新分类
     *
     * @param id       分类ID
     * @param category 分类信息
     * @return 是否更新成功
     */
    @PatchMapping("/{id}")
    public ResponseEntity<CommonResponse<Boolean>> updateCategory(@PathVariable String id,
                                                                  @RequestBody EduCategory category) {
        category.setId(id);
        eduCategoryService.updateCategory(category);
        return ResponseEntity.ok(CommonResponse.ok(true));
    }

}

