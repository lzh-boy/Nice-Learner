package com.example.learner.util;


import com.alibaba.fastjson.JSON;
import com.example.learner.bean.Result;
import com.example.learner.enums.ResultEnums;


public class ResultUtil {
    public static Object success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMsg(ResultEnums.CODE_SUCCESS.getMsg());
        result.setData(object);
        return JSON.toJSON(result);
    }

    public static Object success(){
        return success(null);
    }

    public static Object error(Integer code){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(ResultEnums.msg(code));
        return JSON.toJSON(result);
    }
    public static Object error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return JSON.toJSON(result);
    }
}
