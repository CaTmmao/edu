package com.catmmao.edu.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catmmao.edu.entity.EduCategory;
import com.catmmao.edu.entity.vo.CategoryAndListOfSubcategoryVo;
import org.springframework.stereotype.Service;

/**
 * 课程分类(EduCategory)表服务接口
 *
 * @author catmmao
 * @since 2021-08-20 19:02:36
 */
@Service
public interface EduCategoryService extends IService<EduCategory> {
    // 获取包含子分类的分类列表
    List<CategoryAndListOfSubcategoryVo> getCategoryList();
}

