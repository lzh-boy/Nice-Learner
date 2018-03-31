package com.example.learner.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/3/21
 *
 * 角色表
 */
@Getter
@Setter
public class Role  implements Serializable{

    private Integer id;
    private String role;        // 角色
    private String description; // 角色描述
    private Boolean available = Boolean.FALSE; // 默认不可用

    private List<User> users;

}
