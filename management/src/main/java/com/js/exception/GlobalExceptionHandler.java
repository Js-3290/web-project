package com.js.exception;

import com.js.controller.ActController;
import com.js.pojo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    public Result handleException(Exception e) {
        log.error("程序出错: {}", e.getMessage());
        return Result.error("服务器发生异常");
    }

    @ExceptionHandler
    @ResponseBody
    public Result handleException(DuplicateKeyException e) {
        log.error("程序出错: {}", e.getMessage());
        return Result.error("手机号重复");
    }
}
