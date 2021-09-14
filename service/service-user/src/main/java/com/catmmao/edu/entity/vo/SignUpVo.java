package com.catmmao.edu.entity.vo;

/**
 * @author catmmao
 * @since 2021/9/13 下午5:28
 */
public class SignUpVo {

    // 邮箱号
    private String email;

    // 邮箱验证码
    private String code;

    // 密码
    private String password;

    // 昵称
    private String nickName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
