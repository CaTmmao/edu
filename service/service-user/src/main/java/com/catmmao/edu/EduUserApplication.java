package com.catmmao.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.catmmao")
public class EduUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduUserApplication.class, args);
        System.out.println("ok");
    }
}
