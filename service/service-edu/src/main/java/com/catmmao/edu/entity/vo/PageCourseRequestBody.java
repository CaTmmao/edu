package com.catmmao.edu.entity.vo;

/**
 * @author catmmao
 * @since 2021/8/31 下午7:03
 * 对 edu_course 进行分页查询时可筛选的条件
 */
public class PageCourseRequestBody {
    // 课程标题
    String title;
    // 课程状态
    Boolean status;
    // 课程被创建的开始时间
    private String begin;
    // 课程被创建的结束时间
    private String end;
    // 讲师ID
    private String teacherId;
    // 一级分类ID
    private String categoryFirstId;
    // 二级分类ID
    private String categorySecondId;
    // 根据价格/最新时间/销量排序（值可以为 'price' / 'create_time' / 'buy_count'）
    private String sortField;

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

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
