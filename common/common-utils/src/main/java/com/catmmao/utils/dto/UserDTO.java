package com.catmmao.utils.dto;

/**
 * @author catmmao
 * @since 2021/9/18 下午3:23
 */
public class UserDTO {

    // 用户id
    private String id;

    // 会员昵称
    private String nickname;

    // 会员头像
    private String avatar;

    // 邮箱
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
