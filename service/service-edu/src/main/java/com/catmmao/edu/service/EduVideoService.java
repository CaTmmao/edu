package com.catmmao.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catmmao.edu.entity.EduVideo;
import org.springframework.stereotype.Service;

/**
 * 课程视频(EduVideo)表服务接口
 *
 * @author catmmao
 * @since 2021-08-18 19:21:12
 */
@Service
public interface EduVideoService extends IService<EduVideo> {

    /**
     * 删除视频信息（包括阿里云中保存的视频文件）
     *
     * @param id 视频ID
     */
    void deleteVideoById(String id);

    /**
     * 添加视频
     *
     * @param video 视频信息
     */
    void addVideo(EduVideo video);

    /**
     * 更新视频
     *
     * @param id    视频ID
     * @param video 视频信息
     */
    void updateVideoById(String id, EduVideo video);
}

