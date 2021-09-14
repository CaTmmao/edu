package com.catmmao.edu.service.impl;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;

import com.catmmao.edu.service.SmsService;
import com.catmmao.edu.utils.EMailUtil;
import com.catmmao.utils.exception.HttpException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author catmmao
 * @since 2021/9/12 下午5:45
 */
@Service
public class SmsServiceImpl implements SmsService {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private UserServiceImpl userService;

    @Override
    public void sendRegisterVerificationCode(String email) {

        String code = redisTemplate.opsForValue().get(email);
        if (Strings.isEmpty(code)) {

            // 判断是否存在该邮箱
            if (userService.emailIfExistInDb(email)) {
                throw HttpException.forbidden("该邮箱已注册");
            }

            // 生成随机数
            code = generate6DigitRandomNumber();
            // 将随机数通过邮件发送给用户
            EMailUtil.sendSignUpCodeEmail(email, code);
            // 存储到 redis 中
            redisTemplate.opsForValue().set(email, code, 5, TimeUnit.MINUTES);
        }
    }

    /**
     * 生成 6 位随机数
     *
     * @return 6 位随机数
     */
    private String generate6DigitRandomNumber() {
        Random random = new Random();
        int number = random.nextInt(999999);
        return String.format("%06d", number);
    }
}
