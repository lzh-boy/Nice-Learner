package com.example.learner.service;


import com.example.learner.bean.Role;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/3/21
 */
public interface IRoleService {
    /**
     * 通过id查找角色
     * @param id
     * @return
     */
    Role findRolesById(Integer id);
    /**
     *  添加一位角色
     * @param role
     */
    void add(Role role);
    /**
     * 查找全部角色
     * @return
     */
    List<Role> findAll();
    /**
     * 删除一位角色
     * @param id
     */
    void delete(Integer id);

    /**
     * 更新一位角色
     * @param role
     */
    void update( Role role);
}
