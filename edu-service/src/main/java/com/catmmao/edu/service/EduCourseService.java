package com.catmmao.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catmmao.edu.entity.EduCourse;
import com.catmmao.edu.entity.vo.CourseCompleteInfoVo;
import org.springframework.stereotype.Service;

/**
 * 课程(EduCourse)表服务接口
 *
 * @author catmmao
 * @since 2021-08-18 19:17:47
 */
@Service
public interface EduCourseService extends IService<EduCourse> {
    /**
     * 添加课程
     * @param info 课程信息
     */
    void addCourse(CourseCompleteInfoVo info);
}

