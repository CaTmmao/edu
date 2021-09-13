package com.catmmao.edu.service;

import com.catmmao.edu.entity.vo.SignUpVo;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.catmmao.edu.entity.User;

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
}

