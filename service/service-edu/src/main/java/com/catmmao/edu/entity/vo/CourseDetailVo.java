package com.catmmao.edu.entity.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 课程详情页数据
 *
 * @author catmmao
 * @since 2021/9/16 下午4:29
 */
public class CourseDetailVo {

    //　章节列表
    List<ChapterVo> chapterList;
    // 课程ID
    private String id;
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
    // 销售数量
    private Long buyCount;
    // 浏览数量
    private Long viewCount;
    // 课程讲师ID
    private String teacherId;
    // 讲师姓名
    private String teacherName;
    // 讲师简介
    private String intro;
    // 讲师头像
    private String avatar;
    // 一级分类id
    private String categoryFirstId;
    // 一级分类标题
    private String categoryFirstTitle;
    // 二级分类id
    private String categorySecondId;
    // 二级分类标题
    private String categorySecondTitle;

    public List<ChapterVo> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<ChapterVo> chapterList) {
        this.chapterList = chapterList;
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

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCategoryFirstId() {
        return categoryFirstId;
    }

    public void setCategoryFirstId(String categoryFirstId) {
        this.categoryFirstId = categoryFirstId;
    }

    public String getCategoryFirstTitle() {
        return categoryFirstTitle;
    }

    public void setCategoryFirstTitle(String categoryFirstTitle) {
        this.categoryFirstTitle = categoryFirstTitle;
    }

    public String getCategorySecondId() {
        return categorySecondId;
    }

    public void setCategorySecondId(String categorySecondId) {
        this.categorySecondId = categorySecondId;
    }

    public String getCategorySecondTitle() {
        return categorySecondTitle;
    }

    public void setCategorySecondTitle(String categorySecondTitle) {
        this.categorySecondTitle = categorySecondTitle;
    }
}
