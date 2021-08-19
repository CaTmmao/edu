package com.catmmao.edu.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 课程(EduChapter)实体类
 *
 * @author catmmao
 * @since 2021-08-18 19:17:47
 */
public class EduChapter extends Model<EduChapter> implements Serializable {
    private static final long serialVersionUID = -59890609363733398L;

    // 章节id    
    private String id;

    // 课程id    
    private String courseId;

    // 章节名称    
    private String title;

    // 显示排序    
    private Integer sort;

    // 创建时间    
    private Date createTime;

    // 更新时间    
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
