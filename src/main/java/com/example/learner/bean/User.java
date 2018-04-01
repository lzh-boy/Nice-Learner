package com.example.learner.bean;





import java.io.Serializable;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 与用户登陆表相对应的实体类
 */

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
