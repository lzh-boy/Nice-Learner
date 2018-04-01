package com.example.learner.bean;



import java.io.Serializable;

/**
 * Created by LiQian_Nice on 2018/3/31
 *
 * 日记表
 */

public class Notes implements Serializable{

    private Integer id;//主键

    private Integer userId;//用户id

    private String content;//内容

    private String createDate;//创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
