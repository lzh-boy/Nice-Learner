package com.example.learner.controller.Api;

import com.example.learner.bean.Category;
import com.example.learner.mapper.HobbyMapper;
import com.example.learner.service.impl.HobbyServiceImpl;
import com.example.learner.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/4/5
 */
@Controller
@Api(value="用户爱好接口",tags={"用户爱好Api"})//接口简要标注，对中文的支持不太好
@RequestMapping(value = "/api/hobby")//接口基本路径
public class HobbyController {

    private Logger logger= LoggerFactory.getLogger(HobbyController.class);

    @Resource
    private HobbyServiceImpl hobbyService;


    @GetMapping("/categorys/{userId}")
    @ResponseBody
    @ApiOperation(value = "根据用户id查询用户选择的感兴趣的类别",httpMethod = "GET",response = Category.class)
    private Object findCategorysByUserId(@PathVariable Integer userId){
        List<Category> list=hobbyService.findCategorysByUserId(userId);
        return ResultUtil.success(list);
    }
}
