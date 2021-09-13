package com.catmmao.edu.controller;

import javax.annotation.Resource;

import com.catmmao.edu.entity.User;
import com.catmmao.edu.entity.vo.SignUpVo;
import com.catmmao.edu.service.UserService;
import com.catmmao.utils.data.response.CommonResponse;
import com.catmmao.utils.exception.HttpException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户表(User)表控制层
 *
 * @author catmmao
 * @since 2021-09-13 17:16:22
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 注册
     *
     * @param data 注册信息
     */
    @PostMapping("/session")
    public ResponseEntity<CommonResponse<?>> signUp(@RequestBody SignUpVo data) {

        if (data.getCode() == null || data.getEmail() == null || data.getNickname() == null ||
                data.getPassword() == null) {
            throw HttpException.badRequest("参数不完整");
        }

        userService.signUp(data);
        return ResponseEntity.ok(CommonResponse.ok(null));
    }

    /**
     * 用户登录
     *
     * @param user 用户邮箱和密码
     * @return token
     */
    @PostMapping("/login")
    public ResponseEntity<CommonResponse<String>> login(@RequestBody User user) {

        if (user.getEmail() == null || user.getPassword() == null) {
            throw HttpException.badRequest("参数不完整");
        }

        String token = userService.login(user);
        return ResponseEntity.ok(CommonResponse.ok(token));
    }
}

