package com.catmmao.edu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.catmmao.edu.service.EduOrderService;
import com.catmmao.utils.data.response.CommonResponse;
import com.catmmao.utils.utils.JwtUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单(EduOrder)表控制层
 *
 * @author catmmao
 * @since 2021-09-19 19:01:19
 */
@RestController
@CrossOrigin
@RequestMapping("/service/order")
public class EduOrderController {

    @Resource
    private EduOrderService eduOrderService;

    /**
     * 创建订单
     *
     * @param courseId 课程ID
     * @param request  http请求对象
     * @return 订单号
     */
    @PostMapping("/{courseId}")
    public ResponseEntity<CommonResponse<String>> createOrder(@PathVariable String courseId,
                                                              HttpServletRequest request) {

        String userId = JwtUtils.getUserIdByHttpRequest(request);
        String data = eduOrderService.createOrder(courseId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.ok(data));
    }
}

