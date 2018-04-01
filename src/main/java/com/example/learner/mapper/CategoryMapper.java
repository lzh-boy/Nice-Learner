package com.example.learner.mapper;


import com.example.learner.bean.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类别表数据库操作接口
 */
@Mapper
@Component//mapper层使用@Component注解
public interface CategoryMapper {

    /**
     * 查询所有类别
     * @return
     */
    @Select("select * from tb_category")
    List<Category> findAll();

    /**
     * 根据方向aspectId查询相应的所有类别
     * @param aspectId
     * @return
     */
    @Select("select c.* from tb_category c,tb_aspect a where c.aspectId = a.id and c.aspectId = #{aspectId}")
    List<Category> findCateforysByAspectId(Integer aspectId);


    /**
     * 添加一个类别
     * @param category
     */
    @Insert("insert into tb_category(category,aspectId) values(#{category},#{aspectId})")
    void add(Category category);

    /**
     * 更新一个类别
     * @param category
     */
    @Update("update tb_category set category = #{category} , aspectId = #{aspectId} where id =#{id}" )
    void update(Category category);

    /**
     * 删除一个类别
     * @param id
     */
    @Delete("delete from tb_category where id = #{id}")
    void delete(Integer id);


}
