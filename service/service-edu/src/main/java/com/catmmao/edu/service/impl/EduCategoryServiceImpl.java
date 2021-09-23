package com.catmmao.edu.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catmmao.edu.dao.mapper.EduCategoryMapper;
import com.catmmao.edu.entity.EduCategory;
import com.catmmao.edu.entity.vo.CategoryAndListOfSubcategoryVo;
import com.catmmao.edu.service.EduCategoryService;
import com.catmmao.utils.exception.HttpException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 课程分类(EduCategory)表服务实现类
 *
 * @author catmmao
 * @since 2021-08-20 19:02:36
 */
@Service("eduCategoryService")
public class EduCategoryServiceImpl extends ServiceImpl<EduCategoryMapper, EduCategory> implements EduCategoryService {
    @Override
    public List<CategoryAndListOfSubcategoryVo> getCategoryList() {
        // 获取一级分类列表
        List<EduCategory> list = getCategoryListByParentId("0");
        List<CategoryAndListOfSubcategoryVo> result = list.stream()
                .map(this::convertEduCategory)
                .collect(Collectors.toList());

        // 给一级分类填充子分类列表
        result.forEach(item -> {
            List<EduCategory> sublist = getCategoryListByParentId(item.getId());
            item.setChildren(sublist);
        });

        return result;
    }

    @Override
    public EduCategory getCategoryById(String id) {
        EduCategory result = baseMapper.selectById(id);
        if (result == null) {
            throw HttpException.resourceNotFound("找不到id为 " + id + " 的分类");
        }

        return result;
    }

    @Override
    public void createCategory(EduCategory category) {

        QueryWrapper<EduCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("title", category.getTitle());
        wrapper.eq("parent_id", category.getParentId());
        EduCategory categoryInDb = getOne(wrapper);
        if (categoryInDb != null) {
            throw HttpException.badRequest("已存在同样标题的分类");
        }

        if (!save(category)) {
            throw HttpException.databaseError("添加失败");
        }
    }

    @Transactional
    @Override
    public void deleteCategory(String id) {

        QueryWrapper<EduCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        wrapper.last("or parent_id = " + id);
        if (!remove(wrapper)) {
            throw HttpException.databaseError("删除失败");
        }
    }

    @Override
    public void updateCategory(EduCategory category) {

        EduCategory categoryInDb = getById(category.getId());
        if (categoryInDb == null) {
            throw HttpException.resourceNotFound("找不到该分类");
        }

        if (!updateById(category)) {
            throw HttpException.databaseError("更新失败");
        }
    }

    /**
     * 根据父级分类ID获取子分类列表
     *
     * @param parentId 父级分类ID
     * @return 子分类列表
     */
    private List<EduCategory> getCategoryListByParentId(String parentId) {
        QueryWrapper<EduCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", parentId);

        return baseMapper.selectList(queryWrapper);
    }

    /**
     * EduCategory 类转为 CategoryAndListOfSubcategoryVo
     *
     * @param eduCategory 数据库实体类
     * @return 转换后
     */
    private CategoryAndListOfSubcategoryVo convertEduCategory(EduCategory eduCategory) {
        CategoryAndListOfSubcategoryVo result = new CategoryAndListOfSubcategoryVo();
        BeanUtils.copyProperties(eduCategory, result);
        return result;
    }
}

