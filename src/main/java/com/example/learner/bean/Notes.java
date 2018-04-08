package com.example.learner.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by LiQian_Nice on 2018/3/31
 *
 * 日记表
 */

public class Notes implements Serializable{

    private Integer id;//主键

    @NotNull(message = "用户不能为空")
    private Integer userId;//用户id

    @NotEmpty(message = "内容不能为空")
    private String content;//内容

    private String createDate;//创建时间

    public Notes(){

    }
    public Notes( int userId, String content, String createDate) {
             this.userId=userId;
             this.content=content;
             this.createDate=createDate;
    }


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
