package com.example.learner.bean;


import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by LiQian_Nice on 2018/3/31
 *
 * 课程历史记录表
 */

public class CollectHistory implements Serializable{

    private Integer id;//主键

    @NotNull(message="课程ID不能为空")
    private Integer courseId;//课程id


    private String lastTime;//历史观看最后时间

    @NotNull(message="用戶ID不能为空")
    private Integer userId;//用户id

    @NotNull(message="是否为历史不能为空")
    private boolean ishistory;//是否历史

    @NotNull(message="是否为收藏不能为空")
    private boolean iscollect;//是否收藏


    public CollectHistory() {}

    public CollectHistory(Integer id, Integer courseId, String lastTime, Integer userId, boolean ishistory, boolean iscollect) {
        this.id = id;
        this.courseId = courseId;
        this.lastTime = lastTime;
        this.userId = userId;
        this.ishistory = ishistory;
        this.iscollect = iscollect;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isIshistory() {
        return ishistory;
    }

    public void setIshistory(boolean ishistory) {
        this.ishistory = ishistory;
    }

    public boolean isIscollect() {
        return iscollect;
    }

    public void setIscollect(boolean iscollect) {
        this.iscollect = iscollect;
    }
}
