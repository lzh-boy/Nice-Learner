package com.example.learner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Created by LiQian_Nice on 2018/3/20
 */
@Configuration  //spring boot配置注解
@EnableSwagger2//启用swagger2功能注解
public class Swagger2Configure {

    @Bean
    public Docket createRestApi() {//api文档实例
        //自定义异常信息
        ArrayList<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>() {
            {
                add(new ResponseMessageBuilder().code(200).message("成功").build());
                add(new ResponseMessageBuilder().code(400).message("请求参数错误").responseModel(new ModelRef("Error")).build());
                add(new ResponseMessageBuilder().code(401).message("权限认证失败").responseModel(new ModelRef("Error")).build());
                add(new ResponseMessageBuilder().code(403).message("请求资源不可用").responseModel(new ModelRef("Error")).build());
                add(new ResponseMessageBuilder().code(404).message("请求资源不存在").responseModel(new ModelRef("Error")).build());
                add(new ResponseMessageBuilder().code(409).message("请求资源冲突").responseModel(new ModelRef("Error")).build());
                add(new ResponseMessageBuilder().code(415).message("请求格式错误").responseModel(new ModelRef("Error")).build());
                add(new ResponseMessageBuilder().code(423).message("请求资源被锁定").responseModel(new ModelRef("Error")).build());
                add(new ResponseMessageBuilder().code(500).message("服务器内部错误").responseModel(new ModelRef("Error")).build());
                add(new ResponseMessageBuilder().code(501).message("请求方法不存在").responseModel(new ModelRef("Error")).build());
                add(new ResponseMessageBuilder().code(503).message("服务暂时不可用").responseModel(new ModelRef("Error")).build());
                add(new ResponseMessageBuilder().code(-1).message("未知异常").responseModel(new ModelRef("Error")).build());
            }};
        return new Docket(DocumentationType.SWAGGER_2)//文档类型：DocumentationType.SWAGGER_2
                .apiInfo(apiInfo())//api信息
                .select()//构建api选择器
                .apis(RequestHandlerSelectors.basePackage("com.example.learner.controller"))//api选择器选择api的包
                .paths(PathSelectors.any())//api选择器选择包路径下任何api显示在文档中
                .build()//创建文档
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMessages)
                .globalResponseMessage(RequestMethod.POST, responseMessages)
                .globalResponseMessage(RequestMethod.PUT, responseMessages)
                .globalResponseMessage(RequestMethod.DELETE, responseMessages);
    }

    private ApiInfo apiInfo() {//接口的相关信息
        return new ApiInfoBuilder()
                .title("Learner")
                .description("Base Spring boot2")
                .termsOfServiceUrl("http://localhost:1000/learner.me/")
                .contact("LqNice")
                .version("1.0")
                .build();
    }
}
