package com.catmmao.edu.client;

import com.catmmao.utils.data.response.CommonResponse;
import com.catmmao.utils.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户服务
 *
 * @author catmmao
 * @since 2021/9/18 下午3:08
 */
@FeignClient("service-user")
public interface UserClient {

    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    @GetMapping(value = "/user/{id}")
    ResponseEntity<CommonResponse<UserDTO>> getUserInfoById(@PathVariable String id);
}
