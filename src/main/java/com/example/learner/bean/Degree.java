package com.example.learner.bean;



import java.io.Serializable;

/**
 * Created by LiQian_Nice on 2018/3/31
 *
 * 难度表
 */

public class Degree implements Serializable {

    private Integer id;//主键

    private String degree;//难度

    public Degree(){

    }
    public Degree(Integer id, String degree) {
        this.id=id;
        this.degree=degree;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
