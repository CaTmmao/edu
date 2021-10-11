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

    /**
     * 获取订单信息
     *
     * @param orderNo 订单号
     * @return 订单信息
     */
    EduOrder getOrderByOrderNo(String orderNo);

    /**
     * 更新订单为支付成功状态
     *
     * @param orderNo 订单ID
     */
    void updateOrderPaySuccessByOrderNo(String orderNo);

    /**
     * 检查订单是否支付
     *
     * @param courseId 课程ID
     * @param userId  用户ID
     * @return 是否支付
     */
    boolean checkUserIfBuyCourse(String courseId, String userId);
}

