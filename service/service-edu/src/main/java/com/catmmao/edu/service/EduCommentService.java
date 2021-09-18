package com.catmmao.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catmmao.edu.entity.EduComment;
import com.catmmao.edu.entity.vo.CommentVo;
import org.springframework.stereotype.Service;

/**
 * 评论(EduComment)表服务接口
 *
 * @author catmmao
 * @since 2021-09-17 21:07:05
 */
@Service
public interface EduCommentService extends IService<EduComment> {

    /**
     * 添加评论
     *
     * @param comment 评论信息
     */
    void addComment(CommentVo comment);
}

