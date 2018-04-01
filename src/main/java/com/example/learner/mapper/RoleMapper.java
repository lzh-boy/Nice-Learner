package com.example.learner.mapper;


import com.example.learner.bean.Role;
import org.apache.ibatis.annotations.*;
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
    @Select("SELECT * FROM tb_role WHERE id = #{id}")
    Role findRolesById(Integer id);

    /**
     * 查找全部角色
     * @return
     */
    @Select("SELECT * FROM tb_role")
    List<Role> findAll();

    /**
     * 添加一位角色
     * @param role
     */
    @Insert(" INSERT INTO tb_role(role,description,state) VALUES (#{role},#{description},#{state})")
    void add(Role role);

    /**
     * 更新一位角色
     * @param role
     */
    @Update("update tb_role set role = #{role},description = #{description},state = #{state} where id = #{id} ")
    void update(Role role);

    /**
     * 删除一位角色
     * @param id
     */
    @Delete("DELETE FROM tb_role WHERE id = #{id}")
    void delete(Integer id);
}
