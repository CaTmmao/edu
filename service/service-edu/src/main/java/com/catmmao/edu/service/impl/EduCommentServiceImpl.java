package com.catmmao.edu.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catmmao.edu.client.UserClient;
import com.catmmao.edu.dao.mapper.EduCommentMapper;
import com.catmmao.edu.entity.EduComment;
import com.catmmao.edu.entity.vo.CommentVo;
import com.catmmao.edu.service.EduCommentService;
import com.catmmao.utils.dto.UserDTO;
import com.catmmao.utils.exception.HttpException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 评论(EduComment)表服务实现类
 *
 * @author catmmao
 * @since 2021-09-17 21:07:05
 */
@Service("eduCommentService")
public class EduCommentServiceImpl extends ServiceImpl<EduCommentMapper, EduComment> implements EduCommentService {

    @Resource
    private UserClient userClient;

    @Override
    public void addComment(CommentVo comment) {

        EduComment eduComment = new EduComment();
        BeanUtils.copyProperties(comment, eduComment);

        // 填充用户信息
        UserDTO userDTO = userClient.getUserInfoById(comment.getUserId()).getBody().getData();
        eduComment.setAvatar(userDTO.getAvatar());
        eduComment.setNickname(userDTO.getNickname());

        if (!save(eduComment)) {
            throw HttpException.databaseError("评论添加失败");
        }
    }
}

