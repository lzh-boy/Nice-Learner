package com.example.learner.service;


import com.example.learner.bean.User;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/3/20
 */
public interface IUserService {
    /**
     * 查找全部用户
     * @return
     */
    List<User> findAll();
    /**
     * 通过昵称查找对应得用户
     * @param userName
     * @return
     */
    User findByName(String userName);

    /**
     * 添加一位用户
     * @param user
     */
    void add(User user);
}
