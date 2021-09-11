package com.catmmao.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCaching // 开启缓存功能
@SpringBootApplication(scanBasePackages = "com.catmmao")
@EnableFeignClients
public class EduServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduServiceApplication.class, args);
        System.out.println("ok");
    }
}
