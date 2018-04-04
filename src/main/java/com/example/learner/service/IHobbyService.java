package com.example.learner.service;

import com.example.learner.bean.Category;
import com.example.learner.bean.Hobby;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/4/2
 */
public interface IHobbyService {


    List<Category> findCategorysByUserId(Integer userId);


    void addBatchCategory( List<Hobby> listHobby);
}
