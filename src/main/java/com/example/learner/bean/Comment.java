package com.example.learner.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by LiQian_Nice on 2018/3/31
 *
 * 评论表
 */
@Getter
@Setter
public class Comment implements Serializable{

    private Integer id;//主键

    private Integer chapterId;//章节id

    private String createTime;//创建时间

    private Integer userId;//用户id

    private String content;//评论内容

    private String tocomment;//对哪一条回复

}
