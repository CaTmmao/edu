package com.catmmao.edu.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catmmao.edu.client.VodClient;
import com.catmmao.edu.dao.mapper.EduVideoMapper;
import com.catmmao.edu.entity.EduVideo;
import com.catmmao.edu.service.EduVideoService;
import com.catmmao.utils.exception.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * 课程视频(EduVideo)表服务实现类
 *
 * @author catmmao
 * @since 2021-08-18 19:21:45
 */
@Service("eduVideoService")
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

    @Resource
    private VodClient vodClient;

    @Override
    public void deleteVideoById(String id) {

        EduVideo eduVideo = getVideo(id);
        String vodId = eduVideo.getVodId();

        if (!vodId.isEmpty()) {
            vodClient.deleteVideo(vodId);
        }

        if (!this.removeById(id)) {

            throw HttpException.databaseError("C0300", "数据库中的视频信息删除失败");
        }
    }

    /**
     * 获取视频信息
     *
     * @param id 视频ID
     * @return 视频信息
     */
    private EduVideo getVideo(String id) {

        EduVideo result = this.getById(id);
        if (result == null) {
            throw HttpException.resourceNotFound("C0300", "找不到ID为" + id + "的信息");
        }

        return result;
    }
}

