package com.catmmao.edu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.catmmao.edu.entity.vo.CommentVo;
import com.catmmao.edu.service.EduCommentService;
import com.catmmao.utils.data.response.CommonResponse;
import com.catmmao.utils.exception.HttpException;
import com.catmmao.utils.utils.JwtUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论(EduComment)表控制层
 *
 * @author catmmao
 * @since 2021-09-17 21:07:05
 */
@RestController
@CrossOrigin
@RequestMapping("service/comment")
public class EduCommentController {

    @Resource
    private EduCommentService eduCommentService;

    /**
     * 添加评论
     *
     * @param comment 评论信息
     * @param request http请求
     * @return 是否成功
     */
    @PostMapping
    public ResponseEntity<CommonResponse<Boolean>> addComment(@RequestBody CommentVo comment,
                                                              HttpServletRequest request) {

        String userId = JwtUtils.getUserIdByHttpRequest(request);
        String teacherId = comment.getTeacherId();
        String courseId = comment.getCourseId();
        String content = comment.getContent();
        if (Strings.isEmpty(teacherId) || Strings.isEmpty(courseId) || Strings.isEmpty(content)) {
            throw HttpException.badRequest("参数不完整");
        }

        comment.setUserId(userId);

        eduCommentService.addComment(comment);
        return ResponseEntity.ok(CommonResponse.ok(true));
    }
}

