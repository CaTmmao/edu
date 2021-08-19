package com.catmmao.edu.entity.data;

import java.math.BigDecimal;

public class CourseCompleteInfo {
    // 课程ID
    private String id;

    // 课程讲师ID
    private String teacherId;

    // 课程分类ID
    private String subjectId;

    // 课程标题
    private String title;

    // 课程销售价格，设置为0则可免费观看
    private BigDecimal price;

    // 总课时
    private Integer lessonNum;

    // 课程封面图片路径
    private String cover;

    // 课程简介
    private String description;

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

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
