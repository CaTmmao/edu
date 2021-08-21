package com.catmmao.edu.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catmmao.edu.dao.mapper.EduCourseDescriptionMapper;
import com.catmmao.edu.dao.mapper.EduCourseMapper;
import com.catmmao.edu.entity.EduCourse;
import com.catmmao.edu.entity.EduCourseDescription;
import com.catmmao.edu.entity.vo.CourseInfoVo;
import com.catmmao.edu.exception.HttpException;
import com.catmmao.edu.service.EduCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 课程(EduCourse)表服务实现类
 *
 * @author catmmao
 * @since 2021-08-18 19:21:43
 */
@Service("eduCourseService")
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {
    @Resource
    EduCourseDescriptionMapper eduCourseDescriptionMapper;

    /**
     * 添加课程
     *
     * @param info 课程信息
     * @return boolean 是否添加成功
     */
    @Transactional
    @Override
    public boolean addCourse(CourseInfoVo info) {
        // 课程表中插入数据
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(info, eduCourse);
        int affectedRow = baseMapper.insert(eduCourse);

        if (affectedRow == 0) {
            throw HttpException.databaseError("C0300", "课程表数据插入失败");
        }

        String courseId = eduCourse.getId();

        // 课程简介表中插入数据
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setDescription(info.getDescription());
        eduCourseDescription.setId(courseId);
        affectedRow = eduCourseDescriptionMapper.insert(eduCourseDescription);
        if (affectedRow == 0) {
            throw HttpException.databaseError("C0300", "课程介绍表数据插入失败");
        }

        return true;
    }
}

