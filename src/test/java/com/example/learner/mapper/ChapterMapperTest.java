package com.example.learner.mapper;

import com.example.learner.bean.Chapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/4/1
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ChapterMapperTest {

    private Logger logger= LoggerFactory.getLogger(ChapterMapperTest.class);

    @Resource
    private ChapterMapper chapterMapper;

    @Test
    public void addBatchChapter(){
        List<Chapter> list=new ArrayList<>();
        for (int i=0;i<5;i++){
            Chapter chapter=new Chapter();
            chapter.setTitle("测试"+i);
            chapter.setVideo("测试"+i);
            chapter.setCourseId(3);
            list.add(chapter);
        }
        chapterMapper.addBatchChapter(list);
    }
}
