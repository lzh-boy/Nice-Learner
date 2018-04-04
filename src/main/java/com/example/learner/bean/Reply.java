package com.example.learner.bean;



import java.io.Serializable;

/**
 * Created by LiQian_Nice on 2018/3/31
 *
 * 评论表
 */

public class Reply implements Serializable{

    private Integer id;//主键

    private Integer chapterId;//章节id

    private String createTime;//创建时间

    private Integer userId;//用户id

    private String content;//回复内容

    private Integer commentId;//回复的评论Id



    public Reply() {}

    public Reply(Integer id, Integer chapterId, String createTime, Integer userId, String content, Integer commentId) {
        this.id = id;
        this.chapterId = chapterId;
        this.createTime = createTime;
        this.userId = userId;
        this.content = content;
        this.commentId=commentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCommentId() {return commentId; }

    public void setCommentId(Integer commentId) { this.commentId = commentId; }
}
