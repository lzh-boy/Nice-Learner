package com.example.learner.enums;



public enum ResultEnums {
    CODE_SUCCESS(0000,"访问成功"),         //访问成功
    CODE_ERROR(0001,"访问失败"),
    CODE_ERROR_PARAMETER(0002,"参数错误"),
    CODE_ERROR_PROGRAM(0003,"程序异常"),
    CODE_ERROR_NO_LOGIN_OR_TIMEOUT(0004,"未登录或登录超时"),
    CODE_ERROR_EXIST_OPERATION(0005,"已操作")
    ;
    private Integer code;
    private String msg;
    private static String message = null;
    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public static String msg(int code){

        for (ResultEnums resultEnums:ResultEnums.values()){
            if (resultEnums.getCode().equals(code)){
                message=resultEnums.getMsg();
            }
        }
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static String getMessage() {
        return message;
    }

    public static void main(String[] args) {
        System.out.print(ResultEnums.msg(1));
    }
}
