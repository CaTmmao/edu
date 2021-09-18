package com.catmmao.edu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.catmmao.edu.entity.User;
import com.catmmao.edu.entity.vo.SignUpVo;
import com.catmmao.edu.service.UserService;
import com.catmmao.utils.data.response.CommonResponse;
import com.catmmao.utils.dto.UserDTO;
import com.catmmao.utils.exception.HttpException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @PostMapping("/register")
    public ResponseEntity<CommonResponse<?>> signUp(@RequestBody SignUpVo data) {

        if (data.getCode() == null || data.getEmail() == null || data.getNickName() == null ||
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

    /**
     * 获取用户信息
     *
     * @param request http请求对象
     * @return 用户信息
     */
    @GetMapping
    public ResponseEntity<CommonResponse<User>> getUserInfo(HttpServletRequest request) {

        String token = request.getHeader("token");

        if (Strings.isEmpty(token)) {
            throw HttpException.forbidden("未登录");
        }

        User data = userService.getUserInfo(token);
        return ResponseEntity.ok(CommonResponse.ok(data));
    }

    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<UserDTO>> getUserInfoById(@PathVariable String id) {

        if (Strings.isEmpty(id)) {
            throw HttpException.forbidden("请传入参数");
        }

        User user = userService.getUserInfoById(id);
        UserDTO data = new UserDTO();
        BeanUtils.copyProperties(user, data);
        return ResponseEntity.ok(CommonResponse.ok(data));
    }
}

