package com.example.learner.service;

import com.example.learner.bean.Course;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/4/2
 */
public interface ICourseService {


    /**
     * 查找所有课程
     * @return
     */
    List<Course> findAll();


    /**
     * 根据类别id以及难度id查询所有课程
     * 如果类别id为0,难度id为0相当于查询全部课程
     */
    List<Course> findAllBycategoryIdAndDegreeId(Integer categoryId,Integer degreeId);


    /**
     * 添加一门课程
     * @param course
     */
    void add(Course course);

    /**
     * 更新一门课程
     * @param course
     */
    void update(Course course);

    /**
     * 删除一门课程
     * @param id
     */
    void delete(Integer id);
}
