package com.catmmao.edu.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 用户表(User)实体类
 *
 * @author catmmao
 * @since 2021-09-13 17:16:22
 */
public class User extends Model<User> implements Serializable {
    private static final long serialVersionUID = -56768903094085027L;

    // 用户id    
    private String id;

    // 微信openid    
    private String openid;

    // 邮箱号    
    private String email;

    // 密码    
    private String password;

    // 昵称    
    private String nickname;

    // 性别 1 女，2 男    
    private Boolean sex;

    // 年龄    
    private Boolean age;

    // 用户头像    
    private String avatar;

    // 用户签名    
    private String sign;

    // 是否禁用 1（true）已禁用，  0（false）未禁用    
    private Boolean isDisabled;

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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Boolean getAge() {
        return age;
    }

    public void setAge(Boolean age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Boolean getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(Boolean isDisabled) {
        this.isDisabled = isDisabled;
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
