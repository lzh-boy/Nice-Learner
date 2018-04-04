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
     * 通过课程章节id查找该章节下的所有评论
     * @param chapterId
     * @return
     */
    @Select("SELECT * FROM tb_comment WHERE chapterId = #{chapterId}")
    List<Comment> findCommentByChapterId(Integer chapterId);

    /**
     * 查找全部评论
     * @return
     */
    @Select("SELECT * FROM tb_comment")
    List<Comment> findAll();

    /**
     * 添加一个评论
     * @param comment
     */
    @Insert(" INSERT INTO tb_comment(chapterId,createTime,userId,content) VALUES (#{chapterId},#{createTime},#{userId},#{content})")
    void add(Comment comment);

    /**
     * 更新一个评论
     * @param comment
     */
    @Update("update tb_comment set chapterId = #{chapterId},createTime = #{createTime},userId = #{userId},content = #{content} where id = #{id} ")
    void update(Comment comment);

    /**
     * 删除一个评论
     * @param id
     */
    @Delete("DELETE FROM tb_comment WHERE id = #{id}")
    void delete(Integer id);
}
