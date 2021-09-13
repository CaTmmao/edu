package com.catmmao.edu.entity.vo;

import java.util.ArrayList;
import java.util.List;

import com.catmmao.edu.entity.EduVideo;

public class ChapterVo {
    // 章节ID
    private String id;
    // 视频列表
    private List<EduVideo> children = new ArrayList<>();
    // 章节名称
    private String title;
    // 显示排序
    private Integer sort;

    public void addChildren(EduVideo video) {
        this.children.add(video);
    }

    public List<EduVideo> getChildren() {
        return children;
    }

    public void setChildren(List<EduVideo> children) {
        this.children = children;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
