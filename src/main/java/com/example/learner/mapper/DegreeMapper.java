package com.example.learner.mapper;

import com.example.learner.bean.Degree;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/3/31
 *
 * 难度数据库表操作接口
 */
@Mapper
@Component
public interface DegreeMapper {

    /**
     * 查找所有难度级别
     * @return
     */
    @Select("select * from tb_degree")
    List<Degree> findAll();

    /**
     * 添加一个难度级别
     * @param degree
     */
    @Insert("insert into tb_degree(degree) values (#{degree})")
    void add(String degree);

    /**
     * 更新一个难度级别
     * @param degree
     */
    @Update("update  tb_degree set degree = #{degree} where id = #{id}")
    void update(Degree degree);

    /**
     * 删除一个难度级别
     * @param id
     */
    @Delete("delete from tb_degree where id = #{id}")
    void delete(Integer id);
}
