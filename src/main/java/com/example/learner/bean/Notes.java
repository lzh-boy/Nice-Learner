package com.example.learner.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by LiQian_Nice on 2018/3/31
 *
 * 日记表
 */
@Getter
@Setter
public class Notes implements Serializable{

    private Integer id;//主键

    private Integer userId;//用户id

    private String content;//内容

    private String createDate;//创建时间
}
