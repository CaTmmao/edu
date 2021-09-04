package com.catmmao.edu.controller;

import javax.annotation.Resource;

import com.catmmao.utils.data.response.CommonResponse;
import com.catmmao.edu.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/oss")
public class FileController {
    @Resource
    public FileService fileService;

    /**
     * 上传文件
     *
     * @param file 文件
     * @return oss中文件所在的路径
     */
    @PostMapping("/file")
    public ResponseEntity<CommonResponse<String>> uploadFile(@RequestParam("file") MultipartFile file) {
        String filePath = fileService.uploadFile(file);
        return ResponseEntity.ok(CommonResponse.ok(filePath));
    }
}
