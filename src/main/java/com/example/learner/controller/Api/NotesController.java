package com.example.learner.controller.Api;

import com.example.learner.bean.Notes;
import com.example.learner.service.impl.NotesServiceImpl;
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
@Api(value="用户日记接口",tags={"用户日记Api"})//接口简要标注，对中文的支持不太好
@RequestMapping(value = "/api/notes")//接口基本路径
public class NotesController {

    private Logger logger= LoggerFactory.getLogger(NotesController.class);

    @Resource
    private NotesServiceImpl notesService;

    @GetMapping("/")
    @ResponseBody
    @ApiOperation(value = "查询全部日记",httpMethod = "GET",response = Notes.class)
    private Object findAll(){
        return ResultUtil.success(notesService.findAll());
    }

    @GetMapping("/{userId}")
    @ResponseBody
    @ApiOperation(value = "根据用户id查询其所有的日记",httpMethod = "GET",response = Notes.class)
    private Object findNotesByUserId(@PathVariable("userId") Integer userId){
        return ResultUtil.success(notesService.findNotesByUserId(userId));
    }


    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "添加一个日记",httpMethod = "POST",response = Notes.class)
    private Object add(@ModelAttribute("notes") @Valid Notes notes, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1, LqNiceUtil.hasErrors(bindingResult));
        }
        notes.setCreateDate(LqNiceUtil.getCurrentDateTime());
        notesService.add(notes);
        return ResultUtil.success();
    }

    @PutMapping("/")
    @ResponseBody
    @ApiOperation(value = "更新一个日记",httpMethod = "PUT",response = Notes.class)
    private Object update(@ModelAttribute("notes") @Valid Notes notes, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1, LqNiceUtil.hasErrors(bindingResult));
        }
        notes.setCreateDate(LqNiceUtil.getCurrentDateTime());
        notesService.update(notes);
        return ResultUtil.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "删除一个日记",httpMethod = "DELETE",response = Notes.class)
    private Object delete(@PathVariable("id") Integer id){
        notesService.delete(id);
        return ResultUtil.success();
    }
}
