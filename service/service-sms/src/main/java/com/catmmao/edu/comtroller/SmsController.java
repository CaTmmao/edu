package com.catmmao.edu.comtroller;

import javax.annotation.Resource;

import com.catmmao.edu.service.SmsService;
import com.catmmao.utils.data.response.CommonResponse;
import com.catmmao.utils.exception.HttpException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author catmmao
 * @since 2021/9/12 下午5:22
 */
@RestController
@CrossOrigin
@RequestMapping("/sms")
public class SmsController {

    @Resource
    private SmsService smsService;

    /**
     * 发送邮箱验证码
     *
     * @param email 邮箱
     */
    @GetMapping
    public ResponseEntity<CommonResponse<?>> sendVerificationCode(@RequestParam String email) {

        if (Strings.isEmpty(email)) {
            throw HttpException.badRequest("请输入邮箱");
        }

        smsService.sendVerificationCode(email);
        return ResponseEntity.ok(CommonResponse.ok(null));
    }
}
