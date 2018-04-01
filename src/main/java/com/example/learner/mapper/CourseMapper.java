package com.example.learner.mapper;

import com.example.learner.bean.Course;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/3/31
 *
 * 课程数据库表操作接口
 */
@Mapper
@Component
public interface CourseMapper {

    /**
     * 查找所有课程
     * @return
     */
    @Select("select * from tb_course")
    List<Course> findAll();


    /**
     * 根据类别id以及难度id查询所有课程
     * 如果类别id为0,难度id为0相当于查询全部课程
     */
    List<Course> findAllBycategoryIdAndDegreeId(@Param("categoryId") Integer categoryId,@Param("degreeId") Integer degreeId);


    /**
     * 添加一门课程
     * @param course
     */
    @Insert("insert into tb_course(title,degreeId,categoryId,createTime,authorId,description,lengthTime,status)values(#{title},#{degreeId},#{categoryId},#{createTime},#{authorId},#{description},#{lengthTime},#{status})")
    void add(Course course);

    /**
     * 更新一门课程
     * @param course
     */
    @Update("update tb_course set title=#{title},degreeId=#{degreeId},categoryId=#{categoryId},createTime=#{createTime},description=#{description},lengthTime=#{lengthTime},status=#{status} where id = #{id}")
    void update(Course course);

    /**
     * 删除一门课程
     * @param id
     */
    @Delete("delete from tb_course where id = #{id}")
    void delete(Integer id);

}
