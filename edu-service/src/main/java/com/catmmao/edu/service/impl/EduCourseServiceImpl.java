package com.catmmao.edu.service.impl;

import java.util.List;
import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catmmao.edu.dao.mapper.EduChapterMapper;
import com.catmmao.edu.dao.mapper.EduCourseDescriptionMapper;
import com.catmmao.edu.dao.mapper.EduCourseMapper;
import com.catmmao.edu.dao.mapper.EduVideoMapper;
import com.catmmao.edu.data.response.PageResponse;
import com.catmmao.edu.entity.EduChapter;
import com.catmmao.edu.entity.EduCourse;
import com.catmmao.edu.entity.EduCourseDescription;
import com.catmmao.edu.entity.vo.CourseAndDescriptionVo;
import com.catmmao.edu.entity.vo.CourseCompleteInfoVo;
import com.catmmao.edu.entity.vo.PageCourseRequestBody;
import com.catmmao.edu.exception.HttpException;
import com.catmmao.edu.service.EduCourseDescriptionService;
import com.catmmao.edu.service.EduCourseService;
import org.apache.logging.log4j.util.Strings;
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

    @Resource
    EduChapterMapper eduChapterMapper;

    @Resource
    EduVideoMapper eduVideoMapper;

    @Resource
    EduCourseDescriptionService eduCourseDescriptionService;

    @Transactional
    @Override
    public void addCourse(CourseCompleteInfoVo info) {
        CourseAndDescriptionVo courseAndDescriptionVo = info.getCourseBaseInfo();
        String courseId = this.addCourseBaseInfo(courseAndDescriptionVo);

        info.getChapterList().forEach(chapterVo -> {
            EduChapter chapter = new EduChapter();
            BeanUtils.copyProperties(chapterVo, chapter);
            chapter.setCourseId(courseId);
            int affectedRow = eduChapterMapper.insert(chapter);
            if (affectedRow == 0) {
                throw HttpException.databaseError("C0300", "章节插入失败");
            }
            String chapterId = chapter.getId();

            chapterVo.getChildren().forEach(eduVideo -> {
                if (!eduVideo.getTitle().isEmpty()) {
                    eduVideo.setChapterId(chapterId);
                    eduVideoMapper.insert(eduVideo);
                }
            });
        });
    }

    @Override
    public PageResponse<List<EduCourse>> pageCourseCondition(Integer pageNum, Integer pageSize,
                                                             PageCourseRequestBody condition) {
        Page<EduCourse> pageCourse = new Page<>(pageNum, pageSize);

        if (condition != null) {
            String title = condition.getTitle();
            Boolean status = condition.getStatus();
            String teacherId = condition.getTeacherId();
            String begin = condition.getBegin();
            String end = condition.getEnd();

            QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
            if (!Strings.isEmpty(title)) {
                wrapper.like("title", title);
            }

            if (!Strings.isEmpty(begin)) {
                wrapper.ge("create_time", begin);
            }
            if (!Strings.isEmpty(end)) {
                wrapper.le("create_time", end);
            }

            if (status != null) {
                wrapper.eq("status", status);
            }

            if (!Strings.isEmpty(teacherId)) {
                wrapper.eq("teacher_id", teacherId);
            }

            this.page(pageCourse, wrapper);
        } else {
            this.page(pageCourse);
        }

        pageSize = (int) pageCourse.getSize();
        pageNum = (int) pageCourse.getCurrent();
        Integer total = (int) pageCourse.getTotal();
        Integer totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;

        return PageResponse.pageOk(pageSize, pageNum, total, totalPage, pageCourse.getRecords());
    }

    @Transactional
    @Override
    public void updateCourseAndDescription(CourseAndDescriptionVo courseAndDescriptionVo) {
        // 更新数据库 edu_course 表的数据
        EduCourse newCourse = new EduCourse();
        BeanUtils.copyProperties(courseAndDescriptionVo, newCourse);
        updateCourse(newCourse);

        // 更新数据库 edu_course_description 表的数据
        EduCourseDescription courseDescription = new EduCourseDescription();
        BeanUtils.copyProperties(courseAndDescriptionVo, courseDescription);
        if (!eduCourseDescriptionService.saveOrUpdate(courseDescription)) {
            throw HttpException.databaseError("C0300", "课程信息更新失败");
        }
    }

    /**
     * 更新 edu_course 表中的信息
     *
     * @param newCourse 新的数据
     */
    private void updateCourse(EduCourse newCourse) {
        String id = newCourse.getId();
        getCourse(id);

        if (!this.updateById(newCourse)) {
            throw HttpException.databaseError("C0300", "课程信息更新失败");
        }
    }

    /**
     * 根据课程ID获取 edu_course 表的信息
     *
     * @param courseId 课程ID
     * @return 课程信息
     */
    private EduCourse getCourse(String courseId) {
        EduCourse result = this.getById(courseId);
        if (result == null) {
            throw HttpException.resourceNotFound("C0300", "找不到id为 " + courseId + " 的课程");
        }

        return result;
    }

    /**
     * 添加课程基本信息
     *
     * @param courseAndDescriptionVo 课程基本信息
     * @return 课程ID
     */
    @Transactional
    public String addCourseBaseInfo(CourseAndDescriptionVo courseAndDescriptionVo) {
        // 课程表中插入数据
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseAndDescriptionVo, eduCourse);
        int affectedRow = baseMapper.insert(eduCourse);

        if (affectedRow == 0) {
            throw HttpException.databaseError("C0300", "课程表数据插入失败");
        }

        String courseId = eduCourse.getId();

        // 课程简介表中插入数据
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setDescription(courseAndDescriptionVo.getDescription());
        eduCourseDescription.setId(courseId);
        affectedRow = eduCourseDescriptionMapper.insert(eduCourseDescription);
        if (affectedRow == 0) {
            throw HttpException.databaseError("C0300", "课程介绍表数据插入失败");
        }

        return courseId;
    }


}

