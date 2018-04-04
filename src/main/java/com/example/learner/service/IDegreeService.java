package com.example.learner.service;

import com.example.learner.bean.Degree;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/4/2
 */
public interface IDegreeService {


    /**
     * 查找所有难度级别
     * @return
     */
    List<Degree> findAll();

    /**
     * 添加一个难度级别
     * @param degree
     */
    void add(String degree);

    /**
     * 更新一个难度级别
     * @param degree
     */
    void update(Degree degree);

    /**
     * 删除一个难度级别
     * @param id
     */
    void delete(Integer id);
}
