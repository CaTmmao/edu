package com.catmmao.edu.entity.vo;

import java.util.List;

import com.catmmao.edu.entity.EduCategory;

// 包含所有子分类的分类
public class CategoryAndListOfSubcategoryVo {
    // 所有子分类
    List<EduCategory> children;

    // 课程分类id
    private String id;

    // 分类名称
    private String title;

    // 父级id
    private String parentId;

    // 排序字段
    private Integer sort;

    public List<EduCategory> getChildren() {
        return children;
    }

    public void setChildren(List<EduCategory> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
