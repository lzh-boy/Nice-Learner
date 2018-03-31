package com.example.learner.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by LiQian_Nice on 2018/3/31
 *
 * 课程表
 */
@Getter
@Setter
public class Course implements Serializable{

    private Integer id;//id

    private String title;//标题

    private Integer degreeId;//难度

    private Integer categoryId;//分类

    private String createTime;//创建时间

    private Integer authorId;//教师id

    private String describe;//描述

    private String lengthTime;//时长

    private boolean status;//状态
}
