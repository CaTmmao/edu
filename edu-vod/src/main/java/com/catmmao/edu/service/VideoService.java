package com.catmmao.edu.service;

import org.springframework.web.multipart.MultipartFile;

public interface VideoService {
    /**
     * 上传视频
     *
     * @param file 文件
     * @return 上传成功后阿里云生成的视频ID
     */
    String uploadVideo(MultipartFile file);
}
