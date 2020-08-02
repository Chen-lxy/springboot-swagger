package com.chen.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 // 开启swagger
public class SwaggerConfig {
    // 如果啥都没配，使用的是默认值
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    @Bean
    public Docket docket4(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("D");
    }

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // 配置要扫描接口的方式
                .apis(RequestHandlerSelectors.basePackage("com.chen.study.controller"))
                // 过滤什么路径
                //.paths(PathSelectors.ant("/chen/**"))
                .build()
                // 是否启动swagger,如果使用false,浏览器中不能访问swagger
                //.enable(true)
                // 配置分组
                .groupName("chen")
                .apiInfo(apiInfo());
    }

    // 配置swagger信息---apiInfo
    public ApiInfo apiInfo(){
        // 作者信息
        Contact contact = new Contact("chen", "localhost:8080/hello", "2664582204@qq.com");
        return new ApiInfo("swagger学习",
                "swagger学习。。。。。",
                "1.0",
                "localhost:8080/hello",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
