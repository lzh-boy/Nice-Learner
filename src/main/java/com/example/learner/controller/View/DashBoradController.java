package com.example.learner.controller.View;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by LiQian_Nice on 2018/3/24
 */
@Controller
@Api(value="控制页面跳转接口",tags={"总管理台接口Api"})//接口简要标注，对中文的支持不太好*/
public class DashBoradController {

    private Logger logger= LoggerFactory.getLogger(DashBoradController.class);

    @GetMapping("/")
    @ApiOperation(value = "跳转到主页",httpMethod = "GET")
    public String dashboard() {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.checkRole("assessor");
            logger.info(String.valueOf(subject.getSession()));
        } catch (UnauthorizedException exception) {
            logger.info("没有足够的权限");
        }
        return "dashboard";
    }

    @GetMapping("/login")
    @ApiOperation(value = "用户登陆页面",httpMethod = "GET")
    public String toLogin(){
        return "login";
    }

    @GetMapping("/register")
    @ApiOperation(value = "用户注册页面",httpMethod = "GET")
    public String toRegister(){
        return "register";
    }


    @GetMapping("/forgotPassword")
    @ApiOperation(value = "忘记密码页面",httpMethod = "GET")
    public String forgotPassword(){
        return "forgot-password";
    }

    @GetMapping("/logout")
    @ApiOperation(value = "退出页面",httpMethod = "GET")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
