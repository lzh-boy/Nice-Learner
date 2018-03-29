package com.example.learner.controller.Api;


import com.example.learner.bean.User;
import com.example.learner.service.impl.UserServiceImpl;
import com.example.learner.util.EmailUtil;
import com.example.learner.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by LiQian_Nice on 2018/3/20
 */
@Controller
@Api(value="用户管理接口",tags={"用户管理Api"})//接口简要标注，对中文的支持不太好
@RequestMapping(value = "/api/users")//接口基本路径
public class UserApiController {
    private static Logger logger= LoggerFactory.getLogger(UserApiController.class);

    @Resource
    private UserServiceImpl userService;


    @GetMapping("/")
    @ResponseBody
    @ApiOperation(value = "获取全部用户的信息",httpMethod = "GET",response = User.class)
    public Object findAll(){
        return ResultUtil.success(userService.findAll());
    }

    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "登陆验证",httpMethod = "POST")
    public Object doLogin(@ModelAttribute("user") User user) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);	// 执行登录
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.success();
    }

    @PostMapping("/findPassword/{email}")
    @ResponseBody
    @ApiOperation(value = "找回密码",httpMethod = "POST")
    public Object findPassword(@PathVariable("email") String email) throws Exception {
        logger.info("正在发送");
        EmailUtil.sendMail(email);
        return ResultUtil.success();
    }



}
