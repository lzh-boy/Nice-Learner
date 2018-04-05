package com.example.learner.controller.Api;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.example.learner.util.LqNiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.learner.bean.CollectHistory;
import com.example.learner.service.impl.CollectHistoryServiceImpl;
import com.example.learner.util.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="历史收藏接口",tags={"历史收藏Api"})//接口简要标注，对中文的支持不太好
@RequestMapping(value = "/api/collectHistory")//接口基本路径
public class CollectHistoryController {

	private static Logger logger= LoggerFactory.getLogger(CollectHistoryController.class);

    @Resource
    private CollectHistoryServiceImpl collectHistoryService;
    
    @GetMapping("/")
    @ResponseBody
    @ApiOperation(value = "获取所有历史收藏的信息",httpMethod = "GET",response = CollectHistory.class)
    public Object findAll(){
        return ResultUtil.success(collectHistoryService.findAll());
    }
	
	@GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "通过方向ID获取历史收藏的信息",httpMethod = "GET",response = CollectHistory.class)
	public Object findCollectHistoryById(@PathVariable("id") Integer id) {
		return ResultUtil.success(collectHistoryService.findCollectHistoryById(id));
	}
	
	@PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "添加历史收藏的信息",httpMethod = "POST",response = CollectHistory.class)
    public Object addCollectHistory(@ModelAttribute("collectHistory") @Valid CollectHistory collectHistory, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1, LqNiceUtil.hasErrors(bindingResult));
        }
        collectHistory.setLastTime(LqNiceUtil.getCurrentDateTime());
		collectHistoryService.add(collectHistory);
        return ResultUtil.success();
    }
    
    @PutMapping("/")
    @ResponseBody
    @ApiOperation(value = "更新一条历史收藏的信息",httpMethod = "PUT",response = CollectHistory.class)
    public Object updateCollectHistory(@ModelAttribute("collectHistory") @Valid CollectHistory collectHistory,BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1, LqNiceUtil.hasErrors(bindingResult));
        }
        collectHistory.setLastTime(LqNiceUtil.getCurrentDateTime());
        collectHistoryService.update(collectHistory);
        return ResultUtil.success();
    }
    
    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "删除一条历史收藏的信息",httpMethod = "DELETE",response = CollectHistory.class)
    public Object deleteCollectHistory(@PathVariable("id") Integer id) {
    	collectHistoryService.delete(id);
    	return ResultUtil.success();
    }
}
