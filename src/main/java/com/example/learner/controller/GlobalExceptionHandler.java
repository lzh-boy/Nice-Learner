package com.example.learner.controller;

import com.aliyun.mns.common.ServiceException;
import com.example.learner.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

/**
 * Created by LiQian_Nice on 2018/4/4
 *
 *  统一对异常进行处理的类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    // 日志记录工具
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public Object handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        logger.error("缺少请求参数", e);
        String message = "【缺少请求参数】" + e.getMessage();
        return ResultUtil.error(400,message);
    }
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public Object handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("参数解析失败", e);
        String message = "【参数解析失败】" + e.getMessage();
        return ResultUtil.error(400,message);
    }
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error("参数验证失败", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = "【参数验证失败】" + String.format("%s:%s", field, code);
        return ResultUtil.error(400,message);
    }
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Object handleBindException(BindException e) {
        logger.error("参数绑定失败", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = "【参数绑定失败】" + String.format("%s:%s", field, code);
        return ResultUtil.error(400,message);
    }
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Object handleServiceException(ConstraintViolationException e, Model model) {
        logger.error("参数验证失败", e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = "【参数验证失败】" + violation.getMessage();
        return ResultUtil.error(400,message);
    }
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public Object handleValidationException(ValidationException e) {
        logger.error("参数验证失败", e);
        String message = "【参数验证失败】" + e.getMessage();
        return ResultUtil.error(400,message);
    }
    /**
     * 404 - Not Found
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public Object noHandlerFoundException(NoHandlerFoundException e) {
        logger.error("Not Found", e);
        String message = "【页面不存在】" + e.getMessage();
        System.out.println("404404错误");
        return ResultUtil.error(404,message);
    }
    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Object handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("不支持当前请求方法", e);
        String message = "【不支持当前请求方法】" + e.getMessage();
        return ResultUtil.error(405,message);
    }
    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public Object handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        logger.error("不支持当前媒体类型", e);
        String message = "【不支持当前媒体类型】" + e.getMessage();
        return ResultUtil.error(415,message);
    }
    /**
     * 业务层需要自己声明异常的情况
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Object handleServiceException(ServiceException e) {
        logger.error("业务逻辑异常", e);
        String message = "【业务逻辑异常】" + e.getMessage();
        return ResultUtil.error(-1,message);
    }
    /**
     * 获取其它异常。包括500
     *
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object defaultErrorHandler(Exception e) {
        logger.error("Exception", e);
        String message = e.getMessage();
        return ResultUtil.error(500,message);
    }
}
