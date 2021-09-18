package com.catmmao.edu.client;

import com.catmmao.utils.data.response.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 阿里视频点播服务
 *
 * @author catmmao
 * @since 2021/9/4 下午5:42
 */
@FeignClient(value = "service-vod", fallback = VodClientDegrade.class)
public interface VodClient {

    /**
     * 删除视频
     *
     * @param id 阿里云生成的视频ID
     */
    @DeleteMapping(value = "/vod/{id}")
    ResponseEntity<CommonResponse<?>> deleteVideo(@PathVariable String id);
}
