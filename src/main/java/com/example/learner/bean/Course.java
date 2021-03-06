package com.example.learner.bean;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by LiQian_Nice on 2018/3/31
 *
 * 课程表
 */

public class Course implements Serializable{

    private Integer id;//id

    @NotEmpty(message = "标题不能为空")
    private String title;//标题

    @NotNull(message = "难度不能为空")
    private Integer degreeId;//难度

    @NotNull(message = "分类不能为空")
    private Integer categoryId;//分类


    private String createTime;//创建时间

    @NotNull(message = "教师不能为空")
    private Integer authorId;//教师id

    @NotEmpty(message = "描述不能为空")
    private String description;//描述

    @NotEmpty(message = "时长不能为空")
    private String lengthTime;//时长

    private boolean status=Boolean.FALSE;//状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Integer degreeId) {
        this.degreeId = degreeId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLengthTime() {
        return lengthTime;
    }

    public void setLengthTime(String lengthTime) {
        this.lengthTime = lengthTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
