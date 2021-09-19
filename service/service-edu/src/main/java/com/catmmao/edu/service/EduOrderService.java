package com.catmmao.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catmmao.edu.entity.EduOrder;
import org.springframework.stereotype.Service;

/**
 * 订单(EduOrder)表服务接口
 *
 * @author catmmao
 * @since 2021-09-19 19:01:19
 */
@Service
public interface EduOrderService extends IService<EduOrder> {

    /**
     * 创建订单
     *
     * @param courseId 课程ID
     * @param userId   用户ID
     * @return 订单号
     */
    String createOrder(String courseId, String userId);
}

