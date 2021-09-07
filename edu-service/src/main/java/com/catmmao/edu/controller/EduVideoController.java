package com.catmmao.edu.controller;

import javax.annotation.Resource;

import com.catmmao.edu.service.EduVideoService;
import com.catmmao.utils.data.response.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 课程视频(EduVideo)表控制层
 *
 * @author catmmao
 * @since 2021-08-18 19:21:11
 */
@RestController
@CrossOrigin
@RequestMapping("service/video")
public class EduVideoController {

    @Resource
    private EduVideoService eduVideoService;

    /**
     * 删除视频信息（包括阿里云中保存的视频文件）
     *
     * @param id 视频ID
     * @return 是否成功
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<?>> deleteVideoById(@PathVariable String id) {

        eduVideoService.deleteVideoById(id);
        return ResponseEntity.ok(CommonResponse.ok(true));
    }
}

