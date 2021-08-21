package com.catmmao.edu.service;

import com.catmmao.edu.entity.vo.CourseInfoVo;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.catmmao.edu.entity.EduCourse;

/**
 * 课程(EduCourse)表服务接口
 *
 * @author catmmao
 * @since 2021-08-18 19:17:47
 */
@Service
public interface EduCourseService extends IService<EduCourse> {
    boolean addCourse(CourseInfoVo info);
}

