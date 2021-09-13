package com.catmmao.edu.common;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 公共方法
 *
 * @author catmmao
 * @since 2021/9/4 下午8:23
 */
public class VodUtils {

    /**
     * 填入账号AccessKey信息，进行初始化
     *
     * @param accessKeyId     accessKeyId
     * @param accessKeySecret accessKeySecret
     * @return 发送请求客户端
     */
    public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret) {

        String regionId = "cn-shanghai";  // 点播服务接入区域
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        return new DefaultAcsClient(profile);
    }
}
