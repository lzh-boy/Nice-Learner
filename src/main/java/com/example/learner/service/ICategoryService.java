package com.example.learner.service;


import java.util.List;


import com.example.learner.bean.Category;

/**
 * 课程类别业务逻辑接口
 * @author xyl
 *
 */
public interface ICategoryService {
	/**
     * 查询所有类别
     * @return
     */
    List<Category> findAll();

    /**
     * 根据方向aspectId查询相应的所有类别
     * @param aspectId
     * @return
     */
    List<Category> findCateforysByAspectId(Integer aspectId);


    /**
     * 添加一个类别
     * @param category
     */
    void add(Category category);

    /**
     * 更新一个类别
     * @param category
     */
    void update(Category category);

    /**
     * 删除一个类别
     * @param id
     */
    void delete(Integer id);



}
