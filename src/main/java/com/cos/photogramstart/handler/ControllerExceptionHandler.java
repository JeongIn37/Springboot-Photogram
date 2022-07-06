package com.cos.photogramstart.handler;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ControllerAdvice   // 모든 exception을 낚아채는 역할
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)   // Runtime exception이 발생하는 모든 exception을 가로챔
    public Map<String, String> validationException(CustomValidationException e){
        return e.getErrorMap();
    }
}
