package com.cos.photogramstart.web;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor    // final 필드를 DI할 때 사
@Controller //1.IoC에 등록 2.file을 리턴하는 컨트롤러
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;  // 전역변수에 final이 걸려 있으면 무조건 생성자 필요. 객체가 만들어질 때 초기화 필요
    // -> @RequiredArgsConstructor 사용: final이 걸린 모든 것에 대한 생성자 만듦

/*
    // 생성자 주입
    public AuthController(AuthService authService){
        this.authService = authService;
    }
*/


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
        // User Object에 SignupDto에 있는 데이터를 넣을 것
        User user = signupDto.toEntity();
        log.info(user.toString());
        User userEntity = authService.회원가입(user);
        System.out.println(userEntity);
        return "auth/signin";   // 회원가입 성공시 로그인 페이지로
    }
}
