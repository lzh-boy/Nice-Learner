package com.example.learner.service.impl;

import com.example.learner.bean.Comment;
import com.example.learner.bean.Role;
import com.example.learner.mapper.CommentMapper;
import com.example.learner.service.ICommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/4/2
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findCommentByChapterId(Integer chapterId) {
        return commentMapper.findCommentByChapterId(chapterId);
    }

    @Override
    public List<Comment> findAll() {
        return commentMapper.findAll();
    }

    @Override
    public void add(Comment comment) {
        commentMapper.add(comment);
    }

    @Override
    public void update(Comment comment) {
        commentMapper.update(comment);
    }

    @Override
    public void delete(Integer id) {
        commentMapper.delete(id);
    }
}
