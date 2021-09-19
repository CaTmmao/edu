package com.catmmao.edu.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 订单(EduOrder)实体类
 *
 * @author catmmao
 * @since 2021-09-19 19:01:19
 */
public class EduOrder extends Model<EduOrder> implements Serializable {
    private static final long serialVersionUID = 582660962807723276L;

    private String id;

    // 订单号    
    private String orderNo;

    // 课程id    
    private String courseId;

    // 课程名称    
    private String courseTitle;

    // 课程封面    
    private String courseCover;

    // 讲师名称    
    private String teacherName;

    // 用户id    
    private String userId;

    // 用户昵称    
    private String nickname;

    // 用户邮箱    
    private String email;

    // 订单金额（分）    
    private BigDecimal totalFee;

    // 支付类型（1：微信 2：支付宝）    
    private Boolean payType;

    // 订单状态（0：未支付 1：已支付）    
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCover() {
        return courseCover;
    }

    public void setCourseCover(String courseCover) {
        this.courseCover = courseCover;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public Boolean getPayType() {
        return payType;
    }

    public void setPayType(Boolean payType) {
        this.payType = payType;
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
