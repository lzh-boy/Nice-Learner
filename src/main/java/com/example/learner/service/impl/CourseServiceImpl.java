package com.example.learner.service.impl;

import com.example.learner.bean.Course;
import com.example.learner.mapper.CourseMapper;
import com.example.learner.service.ICourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/4/2
 */
@Service
public class CourseServiceImpl implements ICourseService {

    @Resource
    private CourseMapper courseMapper;

    @Override
    public List<Course> findAll() {
        return courseMapper.findAll();
    }

    @Override
    public List<Course> findAllBycategoryIdAndDegreeId(Integer categoryId, Integer degreeId) {
        return courseMapper.findAllBycategoryIdAndDegreeId(categoryId,degreeId);
    }

    @Override
    public void add(Course course) {
        courseMapper.add(course);
    }

    @Override
    public void update(Course course) {
        courseMapper.update(course);
    }

    @Override
    public void delete(Integer id) {
        courseMapper.delete(id);
    }
}
