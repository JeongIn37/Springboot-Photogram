package com.cos.photogramstart.web;

import com.cos.photogramstart.web.dto.auth.SignupDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //1.IoC에 등록됨 2.file을 리턴하는 컨트롤러
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/auth/signin")
    public String signinForm(){
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm(){
        return "auth/signup";
    }

    // 회원가입 버튼 -> /auth/signup -> /auth/siginin
    // csrf 토큰이 활성화 되어 있어서 실행이 안 됨
    @PostMapping("/auth/signup")    // 회원가입
    public String signup(SignupDto signupDto){ //  key=value 형태(x-www-form-urlencoded)
        log.info(signupDto.toString());
        return "auth/signin";   // 회원가입 성공시 로그인 페이지로
    }
}
