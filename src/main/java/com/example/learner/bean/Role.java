package com.example.learner.bean;



import java.io.Serializable;


/**
 * Created by LiQian_Nice on 2018/3/21
 *
 * 角色表
 */

public class Role  implements Serializable{

    private Integer id;

    private String role;        // 角色

    private String description; // 角色描述

    private Boolean state = Boolean.FALSE; // 默认不可用

    public Role() {

    }

    public Role(String role, String description, boolean state) {
        this.role=role;
        this.description=description;
        this.state=state;
    }



    public Role(int id,String role, String description, boolean state) {
        this.id=id;
        this.role=role;
        this.description=description;
        this.state=state;
    }


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

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
