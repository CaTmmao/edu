package com.catmmao.edu.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catmmao.edu.data.response.PageResponse;
import com.catmmao.edu.entity.EduCourse;
import com.catmmao.edu.entity.vo.CourseCompleteInfoVo;
import com.catmmao.edu.entity.vo.PageCourseRequestBody;
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
     *
     * @param info 课程信息
     */
    void addCourse(CourseCompleteInfoVo info);

    /**
     * 获取所有课程(可筛选条件的分页查询)
     *
     * @param pageNum   当前第几页
     * @param pageSize  每页显示的数量
     * @param condition 筛选条件
     * @return 课程列表
     */
    PageResponse<List<EduCourse>> pageCourseCondition(Integer pageNum, Integer pageSize,
                                                      PageCourseRequestBody condition);
}

