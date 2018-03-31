package com.example.learner.bean;



import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 与用户登陆表相对应的实体类
 */
@Getter
@Setter
public class User implements Serializable{

    private Integer id;                      // 自增长主键，默认ID为1的账号为超级管理员

    private String account;                 //账号

    private String name;                    // 名称

    private String email;                   // 邮箱

    private String plainPassword;           // 登录时的密码，不持久化到数据库

    private String password;                // 加密后的密码

    private String salt;                    //加密盐

    private String createTime;              // 创建时间

    private String phone;                   // 手机号

    private String logo;                    // 头像

    private boolean status=Boolean.FALSE;                 // 用户状态，0表示用户已删除

    private String organization;             // 组织

    private Integer roleId;                 //用户角色

}
