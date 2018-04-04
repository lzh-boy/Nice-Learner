package com.example.learner.service;

import com.example.learner.bean.Comment;
import com.example.learner.bean.Role;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/4/2
 */
public interface ICommentService {

    /**
     * 通过id查找评论
     * @param chapterId
     * @return
     */
    List<Comment> findCommentByChapterId(Integer chapterId);

    /**
     * 查找全部评论
     * @return
     */
    List<Comment> findAll();

    /**
     * 添加一个评论
     * @param comment
     */
    void add(Comment comment);

    /**
     * 更新一个评论
     * @param comment
     */
    void update(Comment comment);

    /**
     * 删除一个评论
     * @param id
     */
    void delete(Integer id);

}
