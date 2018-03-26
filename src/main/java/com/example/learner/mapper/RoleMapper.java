package com.example.learner.mapper;


import com.example.learner.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by LiQian_Nice on 2018/3/21
 */
@Mapper
@Component//mapper层使用@Component注解
public interface RoleMapper {

    /**
     * 通过id查找角色
     * @param id
     * @return
     */
    Role findRolesById(Long id);

    /**
     * 查找全部角色
     * @return
     */
    List<Role> findAll();

    /**
     *  添加一位角色
     * @param role
     */
    void add(Role role);

    /**
     * 删除一位角色
     * @param id
     */
    void delete(Long id);
}
