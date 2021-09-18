package com.catmmao.edu.entity.vo;

/**
 * @author catmmao
 * @since 2021/9/17 下午9:19
 */
public class CommentVo {

    // 课程id
    private String courseId;

    // 讲师id
    private String teacherId;

    // 用户id
    private String userId;

    // 评论内容
    private String content;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
