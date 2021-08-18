package com.catmmao.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catmmao.edu.dao.mapper.EduCourseDescriptionMapper;
import com.catmmao.edu.entity.EduCourseDescription;
import com.catmmao.edu.service.EduCourseDescriptionService;
import org.springframework.stereotype.Service;

/**
 * 课程简介(EduCourseDescription)表服务实现类
 *
 * @author catmmao
 * @since 2021-08-18 19:21:45
 */
@Service("eduCourseDescriptionService")
public class EduCourseDescriptionServiceImpl extends ServiceImpl<EduCourseDescriptionMapper, EduCourseDescription>
    implements EduCourseDescriptionService {

}

