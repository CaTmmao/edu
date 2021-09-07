package com.catmmao.edu.service;

import org.springframework.web.multipart.MultipartFile;

public interface VodService {
    /**
     * 上传视频
     *
     * @param file 文件
     * @return 上传成功后阿里云生成的视频ID
     */
    String uploadVideo(MultipartFile file);

    /**
     * 删除阿里云视频
     *
     * @param id 阿里云生成的视频ID
     */
    void deleteVideo(String id);
}
