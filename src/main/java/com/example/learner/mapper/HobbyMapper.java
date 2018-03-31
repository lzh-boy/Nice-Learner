package com.example.learner.mapper;

import com.example.learner.bean.Category;
import com.example.learner.bean.Hobby;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/3/31
 */
@Mapper
@Component
public interface HobbyMapper {

    /**
     * 根据用户id查询选择的爱好
     * @param userId
     * @return
     */
    @Select("select c.* from tb_hobby h,tb_user u,tb_category c where #{userId} = u.id and h.categoryId = c.id")
    List<Category> findCategorysByUserId(Integer userId);

    /**
     * 批量插入用户添加感兴趣的类别
     * 如果已存在类别，则更新，不存在，则插入
     * @param listHobby
     */
    void addBatchCategory(@Param("listHobby") List<Hobby> listHobby);





}
