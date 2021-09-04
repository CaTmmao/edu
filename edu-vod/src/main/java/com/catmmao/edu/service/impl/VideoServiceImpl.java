package com.catmmao.edu.service.impl;

import java.io.IOException;
import java.io.InputStream;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.catmmao.edu.common.Constant;
import com.catmmao.utils.exception.HttpException;
import com.catmmao.edu.service.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class VideoServiceImpl implements VideoService {
    @Override
    public String uploadVideo(MultipartFile file) {
        String videoId;

        String accessKeyId = Constant.ACCESSKEYID;
        String accessKeySecret = Constant.ACCESSKEYSECRET;
        String fileName = file.getOriginalFilename();
        String title = fileName.substring(0, fileName.lastIndexOf("."));

        // 文件流
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        UploadStreamRequest request =
            new UploadStreamRequest(accessKeyId, accessKeySecret, title, fileName, inputStream);
        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadStreamResponse response = uploader.uploadStream(request);

        videoId = response.getVideoId();

        if (videoId.isEmpty()) {
            String message = "ErrorMessage=" + response.getMessage() + "\n ErrorCode=" + response.getCode();
            throw new HttpException(message, HttpStatus.INTERNAL_SERVER_ERROR, "A0700");
        }

        return videoId;
    }
}
