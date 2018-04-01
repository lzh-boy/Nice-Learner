package com.example.learner.mapper;

import com.example.learner.bean.Course;
import com.example.learner.util.LqNiceUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/4/1
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseMapperTest {

    private Logger logger= LoggerFactory.getLogger(CourseMapperTest.class);


    @Resource
    private CourseMapper courseMapper;

    @Test
    public void findAll(){
        List<Course> list=courseMapper.findAll();
        for (Course course:list){
            logger.info(course.getTitle());
        }
    }

    @Test
    public void findAllBycategoryIdAndDegreeId(){
        List<Course> list=courseMapper.findAllBycategoryIdAndDegreeId(4,2);
        for (Course course:list){
            logger.info(course.getTitle());
        }
    }

    @Test
    public void add(){
        Course course=new Course();
        course.setAuthorId(6);
        course.setCategoryId(7);
        course.setDegreeId(3);
        course.setCreateTime(LqNiceUtil.getCurrentDateTime());
        course.setDescription("test");
        course.setLengthTime(String.valueOf(10));
        course.setTitle("test");
        courseMapper.add(course);
    }

    @Test
    public void update(){
        Course course=new Course();
        course.setAuthorId(6);
        course.setCategoryId(7);
        course.setDegreeId(3);
        course.setCreateTime(LqNiceUtil.getCurrentDateTime());
        course.setDescription("test");
        course.setLengthTime(String.valueOf(10));
        course.setTitle("test");
        course.setId(4);
        course.setStatus(true);
        courseMapper.update(course);
    }

    @Test
    public void delete(){
        courseMapper.delete(4);
    }
}
