package com.example.learner.controller.Api;

import com.example.learner.bean.Role;
import com.example.learner.service.impl.RoleServiceImpl;
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
@Api(value="角色管理接口",tags={"角色管理Api"})//接口简要标注，对中文的支持不太好
@RequestMapping(value = "/api/role")//接口基本路径
public class RoleController {

    private Logger logger= LoggerFactory.getLogger(RoleController.class);

    @Resource
    private RoleServiceImpl roleService;


    @GetMapping("/")
    @ResponseBody
    @ApiOperation(value = "获取全部角色的信息",httpMethod = "GET",response = Role.class)
    public Object findAll(){
        return ResultUtil.success(roleService.findAll());
    }

    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "添加一位角色",httpMethod = "POST",response = Role.class)
    public Object add(@ModelAttribute("role") @Valid Role role, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1, LqNiceUtil.hasErrors(bindingResult));
        }
        roleService.add(role);
        return ResultUtil.success();
    }

    @PutMapping("/")
    @ResponseBody
    @ApiOperation(value = "更新一个角色",httpMethod = "PUT",response = Role.class)
    private Object update(@ModelAttribute("role") @Valid Role role, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1, LqNiceUtil.hasErrors(bindingResult));
        }
        roleService.update(role);
        return ResultUtil.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "删除一个角色",httpMethod = "DELETE",response = Role.class)
    private Object delete(@PathVariable("id") Integer id){
        roleService.delete(id);
        return ResultUtil.success();
    }
}
