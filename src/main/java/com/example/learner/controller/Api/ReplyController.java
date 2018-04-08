package com.example.learner.controller.Api;


import com.example.learner.bean.Reply;
import com.example.learner.util.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.learner.service.impl.ReplyServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * By LTY
 */
@Controller
@Api(value="回复管理接口",tags = {"回复管理Api"})//对中文的支持不友好
@RequestMapping(value = "/api/reply")//接口基本路径
public class ReplyController {
    private static Logger logger=LoggerFactory.getLogger(ReplyController.class);

    @Resource
    private ReplyServiceImpl replyService;

    @GetMapping("/")
    @ResponseBody
    @ApiOperation(value = "获取回复表",httpMethod = "GET",response = Reply.class)
    public Object findAll(){ return ResultUtil.success(replyService.findAll()); }

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "通过id查询回复信息",httpMethod = "GET",response = Reply.class)
    public Object findReplyById(@PathVariable("id") Integer id){ return  ResultUtil.success(replyService.findReplyById(id));}

    @PostMapping("/")
    @ApiOperation(value = "添加回复信息",httpMethod = "POST",response = Reply.class)
    public Object addReply(@ModelAttribute("reply") @Valid Reply reply, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        replyService.add(reply) ;
        return ResultUtil.success();
    }

    @PutMapping("/")
    @ApiOperation(value = "更新回复信息",httpMethod = "PUT",response = Reply.class)
    public Object updateReply(@ModelAttribute("reply") @Valid Reply reply,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        replyService.update(reply);
        return  ResultUtil.success();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "删除回复信息",httpMethod = "DELETE",response = Reply.class)
    public Object deleteReply(@PathVariable("id")Integer id){
        replyService.delete(id);
        return  ResultUtil.success();
    }
}