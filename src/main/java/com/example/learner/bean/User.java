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
    private Long id;                        // 自增长主键，默认ID为1的账号为超级管理员
    private String account;                 // 登录的账号
    private String userName;                // 注册的昵称
    private String plainPassword;           // 登录时的密码，不持久化到数据库
    private String password;                // 加密后的密码
    private String salt;                    // 用于加密的盐
    private String iphone;                  // 手机号
    private String email;                   // 邮箱
    private String platform;                // 用户来自的平台
    private String createdDate;             // 用户注册时间
    private String updatedDate;             // 用户最后一次登录时间
    private Integer status;                 // 用户状态，0表示用户已删除
    private Long rid;//用户角色

}
