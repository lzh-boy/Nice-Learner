package com.example.learner.controller.Api;

import com.example.learner.bean.Degree;
import com.example.learner.service.impl.DegreeServiceImpl;
import com.example.learner.util.LqNiceUtil;
import com.example.learner.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


/**
 * Created by LiQian_Nice on 2018/4/5
 */
@Controller
@Api(value="课程难度接口",tags={"课程难度Api"})//接口简要标注，对中文的支持不太好
@RequestMapping(value = "/api/degree")//接口基本路径
public class DegreeController {

    private Logger logger= LoggerFactory.getLogger(DegreeController.class);

    @Resource
    private DegreeServiceImpl degreeService;



    @GetMapping("/")
    @ResponseBody
    @ApiOperation(value = "查询全部难度",httpMethod = "GET",response = Degree.class)
    private Object findAll(){
        return ResultUtil.success(degreeService.findAll());
    }

    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "添加一条难度",httpMethod = "POST",response = Degree.class)
    private Object add(@ModelAttribute("degree") @Valid Degree degree, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1, LqNiceUtil.hasErrors(bindingResult));
        }
        degreeService.add(degree);
        return ResultUtil.success();
    }


    @PutMapping("/")
    @ResponseBody
    @ApiOperation(value = "更新一条难度",httpMethod = "PUT",response = Degree.class)
    private Object update(@ModelAttribute("degree") @Valid Degree degree,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1, LqNiceUtil.hasErrors(bindingResult));
        }
        degreeService.update(degree);
        return ResultUtil.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "删除一条难度",httpMethod = "DELETE",response = Degree.class)
    private Object delete(@PathVariable("id") Integer id){
        degreeService.delete(id);
        return ResultUtil.success();
    }
}
