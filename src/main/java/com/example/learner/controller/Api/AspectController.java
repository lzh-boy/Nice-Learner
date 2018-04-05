package com.example.learner.controller.Api;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.example.learner.util.LqNiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.learner.bean.Aspect;
import com.example.learner.service.impl.AspectServiceImpl;
import com.example.learner.util.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@Controller
@Api(value="方向接口",tags={"方向Api"})//接口简要标注，对中文的支持不太好
@RequestMapping(value = "/api/aspect")//接口基本路径
public class AspectController {

	private static Logger logger= LoggerFactory.getLogger(AspectController.class);

    @Resource
    private AspectServiceImpl aspectService;
    
    @GetMapping("/")
    @ResponseBody
    @ApiOperation(value = "获取全部方向的信息",httpMethod = "GET",response = Aspect.class)
    public Object findAll(){
        return ResultUtil.success(aspectService.findAll());
    }
    
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "添加方向的信息",httpMethod = "POST",response = Aspect.class)
    public Object addAspect(@ModelAttribute("aspect") @Valid Aspect aspect, BindingResult bindingResult) {
    	if (bindingResult.hasErrors()){
    	    return ResultUtil.error(1, LqNiceUtil.hasErrors(bindingResult));
        }
        aspectService.add(aspect);
    	return ResultUtil.success();
    }

    @PutMapping("/")
    @ResponseBody
    @ApiOperation(value = "更新方向的信息",httpMethod = "PUT",response = Aspect.class)
    public Object updateAspect(@ModelAttribute("aspect") @Valid Aspect aspect,BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,LqNiceUtil.hasErrors(bindingResult));
        }
    	aspectService.update(aspect);
        return ResultUtil.success();
    }
    
    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "根据id删除方向的信息",httpMethod = "DELETE",response = Aspect.class)
    public Object deleteAspect(@PathVariable("id") Integer id) {
    	aspectService.delete(id);
    	return ResultUtil.success();
    }
}
