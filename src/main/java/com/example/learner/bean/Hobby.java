package com.example.learner.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by LiQian_Nice on 2018/3/31
 *
 * 兴趣爱好表
 */
@Getter
@Setter
public class Hobby implements Serializable{

    private Integer userId;//用户id

    private Integer categoryId;//分类id

    public Hobby(int userId, int categoryId) {
        this.userId=userId;
        this.categoryId=categoryId;
    }
}
