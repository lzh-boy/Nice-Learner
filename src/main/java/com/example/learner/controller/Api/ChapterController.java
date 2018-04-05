package com.example.learner.controller.Api;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.learner.service.impl.ChapterServiceImpl;

import io.swagger.annotations.Api;

@Controller
@Api(value="章节接口",tags={"章节Api"})//接口简要标注，对中文的支持不太好
@RequestMapping(value = "/api/chapter")//接口基本路径
public class ChapterController {

	private static Logger logger= LoggerFactory.getLogger(ChapterController.class);
	
	@Resource
    private ChapterServiceImpl chapterService;
	
	
}
