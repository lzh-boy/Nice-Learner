package com.example.learner.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by LiQian_Nice on 2018/3/24
 */
@Controller
@Api(value="总管理台接口",tags={"总管理台接口Api"})//接口简要标注，对中文的支持不太好*/
public class DashBoradController {

    @GetMapping("/")
    @ApiOperation(value = "验证信息是否正确，跳转到主页",httpMethod = "GET")
    public String dashboard() {

        return "dashboard";
    }
}
