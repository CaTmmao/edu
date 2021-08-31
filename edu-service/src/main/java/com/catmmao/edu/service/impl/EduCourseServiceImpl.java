package com.catmmao.edu.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catmmao.edu.dao.mapper.EduChapterMapper;
import com.catmmao.edu.dao.mapper.EduCourseDescriptionMapper;
import com.catmmao.edu.dao.mapper.EduCourseMapper;
import com.catmmao.edu.dao.mapper.EduVideoMapper;
import com.catmmao.edu.entity.EduChapter;
import com.catmmao.edu.entity.EduCourse;
import com.catmmao.edu.entity.EduCourseDescription;
import com.catmmao.edu.entity.vo.CourseAndDescriptionVo;
import com.catmmao.edu.entity.vo.CourseCompleteInfoVo;
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

    @Resource
    EduChapterMapper eduChapterMapper;

    @Resource
    EduVideoMapper eduVideoMapper;

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
}

