package com.catmmao.edu.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catmmao.edu.client.VodClient;
import com.catmmao.edu.dao.mapper.EduChapterMapper;
import com.catmmao.edu.dao.mapper.EduVideoMapper;
import com.catmmao.edu.entity.EduChapter;
import com.catmmao.edu.entity.EduVideo;
import com.catmmao.edu.entity.vo.ChapterVo;
import com.catmmao.edu.service.EduChapterService;
import com.catmmao.edu.service.EduVideoService;
import com.catmmao.utils.exception.HttpException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 课程章节(EduChapter)表服务实现类
 *
 * @author catmmao
 * @since 2021-08-18 19:21:44
 */
@Service("eduChapterService")
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Resource
    private EduVideoMapper eduVideoMapper;

    @Resource
    private EduVideoService eduVideoService;

    @Resource
    private VodClient vodClient;

    @Override
    public List<ChapterVo> getChapterListWithVideoListByCourseId(String courseId) {

        List<EduChapter> chapterList = getChapterListByCourseId(courseId);
        List<ChapterVo> result = converListOfEduChapterToListOfChapterVo(chapterList);
        List<EduVideo> videoList = getVideoListByCourseId(courseId);

        result.forEach(item -> {

            videoList.forEach(eduVideo -> {
                if (Objects.equals(item.getId(), eduVideo.getChapterId())) {

                    item.addChildren(eduVideo);
                }
            });
        });

        return result;
    }

    @Transactional
    @Override
    public void deleteChapterById(String id) {

        // 获取章节下的视频列表
        List<EduVideo> videoList = getVideoListByChapterId(id);

        if (!videoList.isEmpty()) {
            deleteVideoListInAliyun(videoList);
            deleteVideoListInDb(videoList);
        }

        // 删除章节
        if (!removeById(id)) {
            throw HttpException.databaseError("章节删除失败");
        }
    }

    @Override
    public void addChapter(EduChapter chapter) {
        if (!this.save(chapter)) {
            throw HttpException.databaseError("添加章节失败");
        }
    }

    @Override
    public void updateChapterById(String id, EduChapter chapter) {
        EduChapter chapterInDb = getById(id);
        if (chapterInDb == null) {
            throw HttpException.resourceNotFound("找不到ID为" + id + "的章节");
        }

        if (!updateById(chapter)) {
            throw HttpException.databaseError("数据库更新失败");
        }
    }

    /**
     * 删除数据库中的视频列表
     *
     * @param videoList 视频信息列表
     */
    private void deleteVideoListInDb(List<EduVideo> videoList) {

        List<String> videoIdList = videoList.stream()
                .map(EduVideo::getId)
                .collect(Collectors.toList());

        if (!eduVideoService.removeByIds(videoIdList)) {
            throw HttpException.databaseError("视频删除失败");
        }
    }

    /**
     * 删除阿里云中的视频列表
     *
     * @param videoList 视频信息列表
     */
    private void deleteVideoListInAliyun(List<EduVideo> videoList) {

        String vodIdListInString = videoList.stream()
                .filter(item -> {
                    String vodId = item.getVodId();
                    return vodId != null && !vodId.isEmpty();
                })
                .map(EduVideo::getVodId)
                .collect(Collectors.joining(","));

        if (!vodIdListInString.isEmpty()) {
            vodClient.deleteVideo(vodIdListInString);
        }
    }

    /**
     * 根据章节ID获取视频列表
     *
     * @param chapterId 章节ID
     * @return 视频列表
     */
    private List<EduVideo> getVideoListByChapterId(String chapterId) {

        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("chapter_id", chapterId);
        return eduVideoMapper.selectList(wrapper);
    }

    /**
     * <code>
     * List<EduChapter> 转为 List<ChapterVo>
     * </code>
     *
     * @param chapterList
     * @return 目标数组
     */
    private List<ChapterVo> converListOfEduChapterToListOfChapterVo(List<EduChapter> chapterList) {

        return chapterList.stream()
                .map(eduChapter -> {
                    ChapterVo result = new ChapterVo();
                    BeanUtils.copyProperties(eduChapter, result);
                    return result;
                })
                .collect(Collectors.toList());
    }

    /**
     * 获取章节信息
     *
     * @param id 章节ID
     * @return 章节信息
     */
    private EduChapter getChapterById(String id) {

        EduChapter result = this.getById(id);
        if (result == null) {
            throw HttpException.resourceNotFound("找不到id为" + id + "的章节信息");
        }

        return result;
    }

    /**
     * 获取章节列表(并排序：sort asc)
     *
     * @param courseId 课程ID
     * @return 章节列表
     */
    private List<EduChapter> getChapterListByCourseId(String courseId) {

        QueryWrapper<EduChapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        wrapper.orderByAsc("sort");
        return this.list(wrapper);
    }

    /**
     * 获取小节列表(并排序：sort asc)
     *
     * @param courseId 课程ID
     * @return 小节列表
     */
    private List<EduVideo> getVideoListByCourseId(String courseId) {

        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        wrapper.orderByAsc("sort");
        return eduVideoMapper.selectList(wrapper);
    }
}

