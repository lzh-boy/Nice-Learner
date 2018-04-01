package com.example.learner.mapper;

import com.example.learner.bean.Aspect;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 课程方向数据库操作接口
 */
@Mapper
@Component
public interface AspectMapper {
    /**
     * 查找所有方向
     * @return
     */
    @Select("select * from tb_aspect")
    List<Aspect> findAll();

    /**
     * 添加一个方向
     * @param aspect
     */
    @Insert("insert into tb_aspect(aspect) values (#{aspect})")
    void add(String aspect);

    /**
     * 更新一个方向
     * @param aspect
     */
    @Update("update  tb_aspect set aspect = #{aspect} where id = #{id}")
    void update(Aspect aspect);

    /**
     * 删除一个方向
     * @param id
     */
    @Delete("delete from tb_aspect where id = #{id}")
    void delete(Integer id);

}
