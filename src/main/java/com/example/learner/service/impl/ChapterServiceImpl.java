package com.example.learner.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.learner.bean.Chapter;
import com.example.learner.mapper.ChapterMapper;
import com.example.learner.service.IChapterService;

/**
 * 业务层
 * @author xyl
 *
 */
@Service
public class ChapterServiceImpl implements IChapterService {

	@Resource
	private ChapterMapper chapterMapper;
	
	@Override
	public void addBatchChapter(List<Chapter> chapterList) {
           chapterMapper.addBatchChapter(chapterList);
	}

}
