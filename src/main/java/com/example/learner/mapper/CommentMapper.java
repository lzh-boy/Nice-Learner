package com.example.learner.mapper;

import com.example.learner.bean.Comment;
import com.example.learner.bean.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/3/31
 */
@Mapper
@Component
public interface CommentMapper {

    /**
     * 通过id查找角色
     * @param id
     * @return
     */
    @Select("SELECT * FROM tb_comment WHERE id = #{id}")
    Role findCommentById(Integer id);

    /**
     * 查找全部角色
     * @return
     */
    @Select("SELECT * FROM tb_comment")
    List<Comment> findAll();

    /**
     * 添加一位角色
     * @param comment
     */
    @Insert(" INSERT INTO tb_comment(chapterId,createTime,userId,content,tocomment) VALUES (#{chapterId},#{createTime},#{userId},#{content},#{tocomment})")
    void add(Comment comment);

    /**
     * 更新一位角色
     * @param comment
     */
    @Update("update tb_comment set chapterId = #{chapterId},createTime = #{createTime},userId = #{userId},content = #{content},tocomment = #{tocomment} where id = #{id} ")
    void update(Comment comment);

    /**
     * 删除一位角色
     * @param id
     */
    @Delete("DELETE FROM tb_comment WHERE id = #{id}")
    void delete(Integer id);
}
