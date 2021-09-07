package com.catmmao.edu.controller;

import javax.annotation.Resource;

import com.catmmao.edu.service.VodService;
import com.catmmao.utils.data.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/vod")
@CrossOrigin
public class VodController {
    @Resource
    private VodService videoService;

    /**
     * 上传视频到阿里云vod
     *
     * @param file 视频文件
     * @return 上传成功后阿里云生成的视频ID
     */
    @PostMapping
    public ResponseEntity<CommonResponse<String>> uploadVideo(@RequestParam("file") MultipartFile file) {
        //if (file.isEmpty() || )
        String result = videoService.uploadVideo(file);
        return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.ok(result));
    }

    /**
     * 删除阿里云视频
     *
     * @param id 阿里云生成的视频ID
     */
    @DeleteMapping("/{id}")
    void deleteVideo(@PathVariable String id) {

        videoService.deleteVideo(id);
    }
}
