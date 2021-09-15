package com.catmmao.edu.entity.vo;

public class CourseAndDescriptionVo {
    // 课程ID
    private String id;

    // 课程讲师ID
    private String teacherId;

    // 课程标题
    private String title;

    // 一级分类id
    private String categoryFirstId;

    // 二级分类id
    private String categorySecondId;

    // 课程销售价格，设置为0则可免费观看
    private Double price;

    // 总课时
    private Integer lessonNum;

    // 课程封面图片路径
    private String cover;

    // 是否发布
    private Boolean status;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
}
