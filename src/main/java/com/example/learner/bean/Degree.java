package com.example.learner.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by LiQian_Nice on 2018/3/31
 *
 * 难度表
 */
@Getter
@Setter
public class Degree implements Serializable {

    private Integer id;//主键

    private String degree;//难度
}
