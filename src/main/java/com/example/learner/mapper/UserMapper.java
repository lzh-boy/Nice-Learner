package com.example.learner.mapper;

import com.example.learner.bean.Role;
import com.example.learner.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by LiQian_Nice on 2018/3/20
 */
@Mapper
@Component//mapper层使用@Component注解
public interface UserMapper {
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

    /**
     * 根据rid查询对应的角色信息
     * @param rid
     * @return
     */
    Role findRoleByRid(Integer rid);

    /**
     * 根据rid查询相同角色的所有用户
     * @param rid
     * @return
     */
    List<User> findUsersByRid(Integer rid);

    /**
     * 根据id删除一位用户
     * @param id
     */
    void delete(Integer id);
}
