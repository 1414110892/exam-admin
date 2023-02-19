package com.ycx.Exam.Exception;

import com.ycx.Exam.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@ControllerAdvice(annotations = {RestController.class, Controller.class})
@Slf4j
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 异常处理方法
     * @return
     */
    @ExceptionHandler(UserException.class)
    public R<String> exceptionHandler(UserException ex){
        log.error(ex.getMessage());
        return R.error(ex.getMessage());
    }

    @ExceptionHandler(SubjectException.class)
    public R<String> exceptionHandler(SubjectException ex){
        log.error(ex.getMessage());
        return R.error(ex.getMessage());
    }

    /**
     * 异常处理方法
     * @return
     */
    @ExceptionHandler(IOException.class)
    public R<String> exceptionHandler(IOException ex){
        log.error(ex.getMessage());
        return R.error(ex.getMessage());
    }
}

