package com.catmmao.edu.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    /**
     * 上传文件
     *
     * @param file 文件
     * @return oss中文件所在的路径
     */
    String uploadFile(MultipartFile file);
}
