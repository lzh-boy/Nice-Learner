package com.example.learner.bean;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<D> {

    /**错误码*/
    private int code;
    /**提示信息*/
    private String msg;
    /**具体的内容*/
    private D data;

}
