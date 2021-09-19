package com.catmmao.edu.service.impl;

import java.util.Random;
import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catmmao.edu.client.UserClient;
import com.catmmao.edu.dao.mapper.EduOrderMapper;
import com.catmmao.edu.entity.EduOrder;
import com.catmmao.edu.entity.vo.CourseDetailVo;
import com.catmmao.edu.service.EduCourseService;
import com.catmmao.edu.service.EduOrderService;
import com.catmmao.utils.data.response.CommonResponse;
import com.catmmao.utils.dto.UserDTO;
import com.catmmao.utils.exception.HttpException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * 订单(EduOrder)表服务实现类
 *
 * @author catmmao
 * @since 2021-09-19 19:01:19
 */
@Service("eduOrderService")
public class EduOrderServiceImpl extends ServiceImpl<EduOrderMapper, EduOrder> implements EduOrderService {

    @Resource
    private UserClient userClient;

    @Resource
    private EduCourseService eduCourseService;

    @Override
    public String createOrder(String courseId, String userId) {

        // 检查用户是否已经创建了一个订单
        String orderNo = checkOrderIfExist(courseId, userId);

        if (orderNo == null) {

            // 用户信息
            ResponseEntity<CommonResponse<UserDTO>> response = userClient.getUserInfoById(userId);
            UserDTO user = new UserDTO();
            if (response.getBody() != null && response.getBody().getData() != null) {
                user = response.getBody().getData();
            }

            // 课程信息
            CourseDetailVo course = eduCourseService.getCourseDetail(courseId);
            EduOrder order = new EduOrder();
            orderNo = generateOrderNo();
            order.setOrderNo(orderNo);
            order.setEmail(user.getEmail());
            order.setNickname(user.getNickname());
            order.setUserId(userId);
            order.setCourseId(courseId);
            order.setCourseCover(course.getCover());
            order.setCourseTitle(course.getTitle());
            order.setTeacherName(course.getTeacherName());

            if (!save(order)) {
                throw HttpException.databaseError("订单创建失败");
            }
        }

        return orderNo;
    }

    /**
     * 检查用户是否已经创建了订单
     *
     * @param courseId 课程ID
     * @param userId   用户ID
     * @return 订单号
     */
    private String checkOrderIfExist(String courseId, String userId) {

        QueryWrapper<EduOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.eq("course_id", courseId);
        EduOrder orderInDb = getOne(wrapper);
        if (orderInDb != null) {
            return orderInDb.getOrderNo();
        }

        return null;
    }

    /**
     * 生成随机订单号
     *
     * @return 订单号
     */
    private String generateOrderNo() {

        Random random = new Random();
        int number = random.nextInt(9000000) + 1000000;
        Long timeMillis = System.currentTimeMillis();
        return timeMillis + String.valueOf(number);
    }
}

