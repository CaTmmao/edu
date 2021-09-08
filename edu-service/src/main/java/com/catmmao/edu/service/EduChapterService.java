package com.catmmao.edu.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catmmao.edu.entity.EduChapter;
import com.catmmao.edu.entity.vo.ChapterVo;
import org.springframework.stereotype.Service;

/**
 * 课程章节(EduChapter)表服务接口
 *
 * @author catmmao
 * @since 2021-08-18 19:17:47
 */
@Service
public interface EduChapterService extends IService<EduChapter> {

    /**
     * 获取包含视频列表的章节列表
     *
     * @param courseId 课程ID
     * @return 包含视频列表的章节列表
     */
    List<ChapterVo> getChapterListWithVideoListByCourseId(String courseId);

    /**
     * 删除章节
     *
     * @param id 章节ID
     */
    void deleteChapterById(String id);

    /**
     * 添加章节
     *
     * @param chapter 章节信息
     */
    void addChapter(EduChapter chapter);
}

