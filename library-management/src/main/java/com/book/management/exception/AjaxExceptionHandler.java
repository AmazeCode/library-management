package com.book.management.exception;

import com.book.management.common.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Ajax异常处理
 */
@RestControllerAdvice
public class AjaxExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result defaultErrorHandler(HttpServletRequest req,
                                      Exception e) throws Exception {
        e.printStackTrace();
        return Result.fail(e.getMessage());
    }


    /**
     * 注解参数校验 全局异常补获
     * @param ex
     * @return
     */
    @ExceptionHandler(BindException.class)
    public Result handleBindException(BindException ex) {
        //校验 除了 requestbody 注解方式的参数校验 对应的 bindingresult 为 BeanPropertyBindingResult
        FieldError fieldError = ex.getBindingResult().getFieldError();
        return Result.fail(fieldError.getDefaultMessage());
    }

}
