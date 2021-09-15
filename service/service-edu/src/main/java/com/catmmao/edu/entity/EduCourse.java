package com.catmmao.edu.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 课程基本信息(EduCourse)实体类
 *
 * @author catmmao
 * @since 2021-09-15 20:03:39
 */
public class EduCourse extends Model<EduCourse> implements Serializable {
    private static final long serialVersionUID = 823131974419513641L;

    // 课程id    
    private String id;

    // 课程讲师id    
    private String teacherId;

    // 一级分类id
    private String categoryFirstId;

    // 二级分类id
    private String categorySecondId;

    // 课程标题    
    private String title;

    // 课程销售价格，设置为0则可免费观看    
    private Double price;

    // 总课时    
    private Integer lessonNum;

    // 课程封面图片路径    
    private String cover;

    // 销售数量    
    private Long buyCount;

    // 浏览数量    
    private Long viewCount;

    // 乐观锁    
    private Long version;

    // 课程状态 1（true）已发布， 0（false）未发布     
    private Boolean status;

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

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getCategoryFirstId() {
        return categoryFirstId;
    }

    public void setCategoryFirstId(String categoryFirstId) {
        this.categoryFirstId = categoryFirstId;
    }

    public String getCategorySecondId() {
        return categorySecondId;
    }

    public void setCategorySecondId(String categorySecondId) {
        this.categorySecondId = categorySecondId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(Integer lessonNum) {
        this.lessonNum = lessonNum;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Long getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Long buyCount) {
        this.buyCount = buyCount;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
