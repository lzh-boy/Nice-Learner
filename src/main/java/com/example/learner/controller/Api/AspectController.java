package com.example.learner.controller.Api;

import com.example.learner.bean.Aspect;
import com.example.learner.service.impl.AspectServiceImpl;
import com.example.learner.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/4/3
 */
@Controller
@RequestMapping("/api/aspects")
@Api(value="方向管理接口",tags={"方向管理Api"})
public class AspectController {


    @Resource
    private AspectServiceImpl aspectService;


    @GetMapping("/")
    @ResponseBody
    @ApiOperation(value = "获取全部方向的信息",httpMethod = "GET",response = Aspect.class)
    public Object findAll(){
        List<Aspect> list=aspectService.findAll();
        return ResultUtil.success(list);
    }
}
