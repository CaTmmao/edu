package com.catmmao.edu.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component
public class Swagger {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.regex("^(?!(/error)).*"))
            .build();
    }

    //接口文档信息
    private ApiInfo apiInfo() {
        return new ApiInfo(
            "在线教育接口",
            "在线教育接口",
            "1",
            "",
            new Contact("catmmao", "", "catmmao@gmail.com"),
            "", "", Collections.emptyList());
    }
}
