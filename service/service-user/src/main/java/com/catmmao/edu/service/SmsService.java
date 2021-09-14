package com.catmmao.edu.service;

/**
 * @author catmmao
 * @since 2021/9/12 下午5:44
 */
public interface SmsService {

    /**
     * 发送注册验证码
     *
     * @param email 邮箱
     */
    void sendRegisterVerificationCode(String email);
}
