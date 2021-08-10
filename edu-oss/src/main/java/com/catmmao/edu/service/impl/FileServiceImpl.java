package com.catmmao.edu.service.impl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.catmmao.edu.entity.Oss;
import com.catmmao.edu.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadFile(MultipartFile file) {
        String endpoint = Oss.ENDPOINT;
        String accessKeyId = Oss.ACCESSKEYID;
        String accessKeySecret = Oss.ACCESSKEYSECRET;
        String bucketName = Oss.BUCKETNAME;

        // 文件名
        String fileName = generateFileName(file.getOriginalFilename());

        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            InputStream inputStream = file.getInputStream();

            // 上传文件
            ossClient.putObject(
                // Bucket名称（例如examplebucket）
                Oss.BUCKETNAME,
                // 文件完整路径（例如exampledir/exampleobject.txt）文件完整路径中不能包含Bucket名称。
                fileName,
                inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }

        /*
         * 文件URL的格式为 https:BucketName.Endpoint/ObjectName
         * 其中，ObjectName需填写包含文件夹以及文件后缀在内的该文件的完整路径
         */
        return "https://" + bucketName + "." + endpoint + "/" + fileName;
    }

    /**
     * 生成文件名
     *
     * @param originalFilename 最初文件名
     * @return 处理后的文件名
     */
    private String generateFileName(String originalFilename) {
        // uuid 生成随机数避免文件名重复将其他文件覆盖
        String uuid = UUID.randomUUID().toString();

        // 文件按照时间进行分类
        String pattern = "yyyy/MM/dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        return date + "/" + originalFilename + uuid;
    }
}
