package com.example.learner.service.impl;

import com.example.learner.bean.Role;
import com.example.learner.bean.User;
import com.example.learner.mapper.UserMapper;
import com.example.learner.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by LiQian_Nice on 2018/3/20
 */
@Service//告诉Spring，当Spring要创建UserServiceImpl的的实例时，bean的名字必须叫做"userService"
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findByName(String userName) {
        return userMapper.findByName(userName);
    }


    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public Role findRoleByRid(long rid) {
        return userMapper.findRoleByRid(rid);
    }

    @Override
    public List<User> findUsersByRid(long rid) {
        return userMapper.findUsersByRid(rid);
    }

    @Override
    public void delete(long id) {
        userMapper.delete(id);
    }
}
