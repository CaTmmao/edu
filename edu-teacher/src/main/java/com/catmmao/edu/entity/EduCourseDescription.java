package com.catmmao.edu.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 课程简介(EduCourseDescription)实体类
 *
 * @author catmmao
 * @since 2021-08-18 19:17:47
 */
public class EduCourseDescription extends Model<EduCourseDescription> implements Serializable {
    private static final long serialVersionUID = -72590769318411811L;

    // 课程id    
    private String id;

    // 课程简介    
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
