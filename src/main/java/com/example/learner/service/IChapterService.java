package com.example.learner.service;

import java.util.List;

import com.example.learner.bean.Chapter;

/**
 *章节信业务逻辑接口
 * @author xyl
 *
 */
public interface IChapterService {

	/**
     * 批量添加一门课程的章节信息
     * @param chapterList
     */
	void addBatchChapter(List<Chapter> chapterList);
}
