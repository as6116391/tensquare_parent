package com.tensquare.article.controller;

import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author : 闵波路三舅
 * @Date : 2020-05-07 21:04
 * @ClassName : BaseExceptionHandler
 * @Description : 统一异常处理类
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result handlerException(Exception e){

        String message = e.getMessage();
        //判断异常信息是否是 ArithmeticException 异常
        if (e instanceof ArithmeticException){
            message = "不能为0";
        }

        System.out.println("aaaa");
        System.out.println("没有");
        System.out.println("bbbb");
        return new Result(false, StatusCode.ERROR,message);
    }

}
