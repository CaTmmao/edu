package com.catmmao.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//不需要配置数据库
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EduOssApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduOssApplication.class, args);
        System.out.println("ok");
    }
}
