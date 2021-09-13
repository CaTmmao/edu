package com.catmmao.edu.utils;

import com.catmmao.utils.exception.HttpException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.http.HttpStatus;

/**
 * @author catmmao
 * @since 2021/9/13 上午9:17
 */
public class EMailUtil {

    /*
     * 发送注册验证码的邮件
     * @param to 收件人
     * @param code 验证码
     */
    public static void sendSignUpCodeEmail(String to, String code) {

        String subject = "[CAT在线教育网站]注册验证码";
        String content = "您正在申请用邮箱注册帐号，验证码为：" + code + "，5分钟内有效！\n";
        send(to, subject, content);
    }

    /**
     * 发送邮件
     *
     * @param to      收件人
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    private static void send(String to, String subject, String content) {

        HtmlEmail email = new HtmlEmail();

        try {

            email.setHostName("smtp.163.com");
            email.setCharset("UTF-8");
            email.addTo(to);
            email.setFrom("catmmao@163.com", "catmmao");
            email.setAuthentication("catmmao@163.com", "OHEGEINJHNJNTPRO");
            email.setSubject(subject);
            email.setMsg(content);
            email.send();
        } catch (Exception e) {

            e.printStackTrace();
            throw new HttpException("验证码发送失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
