package com.example.learner.bean;






import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by LiQian_Nice on 2018/3/31
 *
 * 兴趣爱好表
 */


public class Hobby implements Serializable{

    @NotNull(message = "用户不能为空")
    private Integer userId;//用户id

    @NotNull(message = "分类不能为空")
    private Integer categoryId;//分类id

    public Hobby(Integer userId, Integer categoryId){
        this.userId=userId;
        this.categoryId=categoryId;
    }

    public Hobby() {

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
