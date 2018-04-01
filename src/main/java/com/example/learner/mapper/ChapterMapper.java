package com.example.learner.mapper;

import com.example.learner.bean.Chapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface ChapterMapper {

    /**
     * 批量添加一门课程的章节信息
     * @param chapterList
     */
    void addBatchChapter(@Param("chapterList") List<Chapter> chapterList);

}
