package com.catmmao.edu.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 讲师(EduTeacher)实体类
 *
 * @author catmmao
 * @since 2021-08-06 19:56:26
 */
public class EduTeacher extends Model<EduTeacher> implements Serializable {
    private static final long serialVersionUID = -16866345135250242L;

    // 讲师id    
    private String id;

    // 讲师姓名    
    private String name;

    // 讲师简介    
    private String intro;

    // 讲师资历,一句话说明讲师    
    private String career;

    // 头衔 1高级讲师 2首席讲师    
    private Integer level;

    // 讲师头像    
    private String avatar;

    // 排序    
    private Integer sort;

    // 逻辑删除 1（true）已删除， 0（false）未删除    
    private Boolean isDeleted;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
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
