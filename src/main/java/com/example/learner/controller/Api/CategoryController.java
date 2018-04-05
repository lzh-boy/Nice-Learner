package com.example.learner.controller.Api;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.example.learner.util.LqNiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.learner.bean.Category;
import com.example.learner.service.impl.CategoryServiceImpl;
import com.example.learner.util.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="分类接口",tags={"分类Api"})//接口简要标注，对中文的支持不太好
@RequestMapping(value = "/api/category")//接口基本路径
public class CategoryController {

	private static Logger logger= LoggerFactory.getLogger(CategoryController.class);
	
	@Resource
    private CategoryServiceImpl categoryService;
	
	@GetMapping("/")
    @ResponseBody
    @ApiOperation(value = "获取所有分类的信息",httpMethod = "GET",response = Category.class)
    public Object findAll(){
        return ResultUtil.success(categoryService.findAll());
    }
	
	@GetMapping("/{aspectId}")
    @ResponseBody
    @ApiOperation(value = "通过方向ID获取分类信息",httpMethod = "GET",response = Category.class)
	public Object findCateforysByAspectId(@PathVariable("aspectId")Integer aspectId) {
		return ResultUtil.success(categoryService.findCateforysByAspectId(aspectId));
	}
	
	@PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "添加一条分类信息",httpMethod = "POST",response = Category.class)
    public Object addCategory(@ModelAttribute("category") @Valid Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1, LqNiceUtil.hasErrors(bindingResult));
        }
	    categoryService.add(category);
        return ResultUtil.success();
    }
    
    @PutMapping("/{category}")
    @ResponseBody
    @ApiOperation(value = "更新一条分类信息",httpMethod = "POST",response = Category.class)
    public Object updateCategory(@ModelAttribute("category") @Valid Category category,BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1, LqNiceUtil.hasErrors(bindingResult));
        }
    	categoryService.update(category);
        return ResultUtil.success();
    }
    
    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "删除一条分类信息",httpMethod = "DELETE",response = Category.class)
    public void deleteCategory(@PathVariable("id") Integer id) {
    	categoryService.delete(id);
    }
}
