package com.catmmao.edu.client;

import com.catmmao.utils.data.response.CommonResponse;
import com.catmmao.utils.exception.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author catmmao
 * @since 2021/9/9 下午2:17
 */
@Component
public class VodClientDegrade implements VodClient {
    @Override
    public ResponseEntity<CommonResponse<?>> deleteVideo(String id) {
        throw new HttpException("视频删除失败", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
