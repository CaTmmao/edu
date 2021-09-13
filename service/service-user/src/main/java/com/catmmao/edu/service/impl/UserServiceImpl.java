package com.catmmao.edu.service.impl;

import javax.annotation.Resource;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catmmao.edu.dao.mapper.UserMapper;
import com.catmmao.edu.entity.User;
import com.catmmao.edu.entity.vo.SignUpVo;
import com.catmmao.edu.service.UserService;
import com.catmmao.edu.utils.JwtUtils;
import com.catmmao.utils.exception.HttpException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author catmmao
 * @since 2021-09-13 17:16:22
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void signUp(SignUpVo data) {

        // 判断邮箱是否已经注册
        String email = data.getEmail();
        if (emailIfExistInDb(email)) {
            throw HttpException.badRequest("该邮箱已注册");
        }

        // 检查验证码是否正确
        String codeInRedis = redisTemplate.opsForValue().get(email);
        if (!data.getCode().equals(codeInRedis)) {
            throw HttpException.badRequest("验证码错误");
        }

        // 存储到数据库中
        String password = data.getPassword();
        data.setPassword(SecureUtil.md5(password));
        User user = new User();
        BeanUtils.copyProperties(data, user);
        if (!save(user)) {
            throw HttpException.databaseError("注册失败");
        }
    }

    @Override
    public String login(User user) {

        String email = user.getEmail();
        String password = SecureUtil.md5(user.getPassword());

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email", email);
        User userInDb = getOne(wrapper);

        if (userInDb == null) {
            throw HttpException.badRequest("不存在该用户");
        }

        if (!password.equals(userInDb.getPassword())) {
            throw HttpException.badRequest("密码错误");
        }

        if (userInDb.getIsDisabled()) {
            throw HttpException.forbidden("用户被禁用");
        }

        // 生成token
        return JwtUtils.generateToken(userInDb.getId(), userInDb.getNickname());
    }

    /**
     * 数据库中是否已存在该邮箱
     *
     * @param email 邮箱号
     * @return 是否存在
     */
    private boolean emailIfExistInDb(String email) {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email", email);
        return count(wrapper) > 0;
    }
}

