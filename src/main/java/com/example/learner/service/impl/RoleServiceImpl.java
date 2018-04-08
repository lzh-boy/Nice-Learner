package com.example.learner.service.impl;


import com.example.learner.bean.Role;
import com.example.learner.mapper.RoleMapper;
import com.example.learner.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by LiQian_Nice on 2018/3/21
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Role findRolesById(Integer id) {
        return roleMapper.findRolesById(id);
    }

    @Override
    public void add(Role role) {
        roleMapper.add(role);
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public void delete(Integer id) {
        roleMapper.delete(id);
    }

    @Override
    public void update(Role role) {
        roleMapper.update(role);
    }
}
