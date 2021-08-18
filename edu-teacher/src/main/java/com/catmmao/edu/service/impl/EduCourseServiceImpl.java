package com.catmmao.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catmmao.edu.dao.mapper.EduCourseMapper;
import com.catmmao.edu.entity.EduCourse;
import com.catmmao.edu.service.EduCourseService;
import org.springframework.stereotype.Service;

/**
 * 课程(EduCourse)表服务实现类
 *
 * @author catmmao
 * @since 2021-08-18 19:21:43
 */
@Service("eduCourseService")
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {
}

