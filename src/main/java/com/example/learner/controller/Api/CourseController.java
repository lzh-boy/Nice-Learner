package com.example.learner.controller.Api;

import com.example.learner.bean.Course;
import com.example.learner.service.impl.CourseServiceImpl;
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
 * Created by LiQian_Nice on 2018/4/8
 */
@Controller
@Api(value="课程管理接口",tags={"课程管理Api"})//接口简要标注，对中文的支持不太好
@RequestMapping(value = "/api/course")//接口基本路径
public class CourseController {
    private Logger logger= LoggerFactory.getLogger(CourseController.class);

    @Resource
    private CourseServiceImpl courseService;

    @GetMapping("/")
    @ResponseBody
    @ApiOperation(value = "查询全部课程",httpMethod = "GET",response = Course.class)
    private Object findAll(){
        return ResultUtil.success(courseService.findAll());
    }

 /*   @GetMapping("/{userId}")
    @ResponseBody
    @ApiOperation(value = "根据用户id查询其所有的日记",httpMethod = "GET",response = Course.class)
    private Object findNotesByUserId(@PathVariable("userId") Integer userId){
        return ResultUtil.success(notesService.findNotesByUserId(userId));
    }*/


    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "添加一个课程",httpMethod = "POST",response = Course.class)
    private Object add(@ModelAttribute("course") @Valid Course course, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1, LqNiceUtil.hasErrors(bindingResult));
        }
        course.setCreateTime(LqNiceUtil.getCurrentDateTime());
        courseService.add(course);
        return ResultUtil.success();
    }

    @PutMapping("/")
    @ResponseBody
    @ApiOperation(value = "更新一个课程",httpMethod = "PUT",response = Course.class)
    private Object update(@ModelAttribute("course") @Valid Course course, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1, LqNiceUtil.hasErrors(bindingResult));
        }
        course.setCreateTime(LqNiceUtil.getCurrentDateTime());
        courseService.update(course);
        return ResultUtil.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "删除一个课程",httpMethod = "DELETE",response = Course.class)
    private Object delete(@PathVariable("id") Integer id){
        courseService.delete(id);
        return ResultUtil.success();
    }
}
