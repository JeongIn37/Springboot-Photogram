package com.cos.photogramstart.handler;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.util.Script;
import com.cos.photogramstart.web.dto.CMRespDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ControllerAdvice   // 모든 exception을 낚아채는 역할
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)   // Runtime exception이 발생하는 모든 exception을 가로챔
    public String validationException(CustomValidationException e){   // ?: 리턴시에 자동으로 바

        /* CMRespDto, Script 비교
            1. 클라이언트에게 응답할 때: Script가 좋음
            2. Ajax 통신 - CMRespDto
            3. Android 통신 - CMRespDto
         */
        return Script.back(e.getErrorMap().toString());
        //return new CMRespDto<Map<String, String>>(-1, e.getMessage(), e.getErrorMap());
    }
}
