package com.example.learner.mapper;

import com.example.learner.bean.Reply;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ReplyMapper {

	/**
     * 通过id查找回复
     * @param id
     * @return
     */
    @Select("SELECT * FROM tb_reply WHERE id = #{id}")
    Reply findReplyById(Integer id);

    /**
     * 查找全部回复
     * @return
     */
    @Select("SELECT * FROM tb_reply")
    List<Reply> findAll();

    /**
     * 添加一位回复
     * @param reply
     */
    @Insert(" INSERT INTO tb_reply(chapterId,createTime,userId,content,commentId) VALUES (#{chapterId},#{createTime},#{userId},#{content},#{commentId})")
    void add(Reply reply);

    /**
     * 更新一位回复
     * @param reply
     */
    @Update("update tb_reply set chapterId = #{chapterId},createTime = #{createTime},userId = #{userId},content = #{content},commentId = #{commentId} where id = #{id} ")
    void update(Reply reply);

    /**
     * 删除一位回复
     * @param id
     */
    @Delete("DELETE FROM tb_reply WHERE id = #{id}")
    void delete(Integer id);
}
