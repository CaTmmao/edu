package com.catmmao.edu.service.impl;

import java.io.IOException;
import java.io.InputStream;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.catmmao.edu.common.Constant;
import com.catmmao.edu.common.VodUtils;
import com.catmmao.edu.service.VodService;
import com.catmmao.utils.exception.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class VodServiceImpl implements VodService {

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
            throw new HttpException(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return videoId;
    }

    /**
     * 删除视频
     *
     * @param vodId 视频ID
     */
    @Override
    public void deleteVideo(String vodId) {

        try {
            DefaultAcsClient client = VodUtils.initVodClient(Constant.ACCESSKEYID, Constant.ACCESSKEYSECRET);
            DeleteVideoRequest deleteVideoRequest = new DeleteVideoRequest();
            deleteVideoRequest.setVideoIds(vodId);
            client.getAcsResponse(deleteVideoRequest);
        } catch (Exception e) {
            e.printStackTrace();
            String errorCodeAndMessage = e.getLocalizedMessage();

            // 视频不存在
            if (errorCodeAndMessage.contains("InvalidVideo.NotFound")) {
                throw HttpException.resourceNotFound("不存在vodId为" + vodId + "的视频，删除失败");
            } else if (errorCodeAndMessage.contains("DeleteVideoFailed")) {
                throw new HttpException("删除视频失败，请稍后重试。", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @Override
    public String getVideoPlayAuth(String id) {

        try {
            DefaultAcsClient client = VodUtils.initVodClient(Constant.ACCESSKEYID, Constant.ACCESSKEYSECRET);
            GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
            request.setVideoId(id);
            GetVideoPlayAuthResponse response = client.getAcsResponse(request);
            return response.getPlayAuth();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HttpException("视频凭证获取失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
