package com.example.learner.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by LiQian_Nice on 2018/3/31
 *
 * 课程历史记录表
 */
@Getter
@Setter
public class CollectHistory implements Serializable{

    private Integer id;//主键

    private Integer courseId;//课程id

    private String lastTime;//最后时间

    private Integer userId;//用户id

    private boolean ishistory;//是否历史

    private boolean iscollect;//是否收藏

}
