package com.catmmao.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catmmao.edu.entity.User;
import com.catmmao.edu.entity.vo.SignUpVo;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务接口
 *
 * @author catmmao
 * @since 2021-09-13 17:16:22
 */
@Service
public interface UserService extends IService<User> {

    /**
     * 注册
     *
     * @param data 注册信息
     */
    void signUp(SignUpVo data);

    /**
     * 用户登录
     *
     * @param user 用户邮箱和密码
     * @return token
     */
    String login(User user);

    /**
     * 获取用户信息
     *
     * @param token token
     * @return 用户信息
     */
    User getUserInfo(String token);
}

