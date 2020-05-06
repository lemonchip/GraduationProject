package cn.closer.space.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName SpaceException.java
 * @Description TODO
 * @createTime 2020年03月10日 11:46:00
 */
@ControllerAdvice
public class SpaceException  {

    @ExceptionHandler(value = Exception.class)
    public Result exception(Exception e){

        /**
         * 描述：捕获 ArithmeticException 异常
         * @param model 将Model对象注入到方法中
         * @param e 将产生异常对象注入到方法中
         * @return 指定错误页面
         */
        e.printStackTrace();
        return new Result(false,StatusCode.ERROR,e.getMessage());

    }
}
