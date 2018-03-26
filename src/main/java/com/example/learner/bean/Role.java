package com.example.learner.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/3/21
 *
 * 角色表
 */
public class Role implements Serializable{

    private Integer id;
    private String role;        // 角色
    private String description; // 角色描述
    private Boolean available = Boolean.FALSE; // 默认不可用

    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
