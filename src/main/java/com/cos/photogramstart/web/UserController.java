package com.cos.photogramstart.web;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @GetMapping("/user/{id}")
    public String profile(@PathVariable int id){    // user별 profile 페이지 이동을 위해 id 추가
        return "user/profile";
    }

    @GetMapping("user/{id}/update")
    public String update(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails){ //AuthenticationPricinpal: 세션에 접근하기 위해 사용

        //1. 추천
        System.out.printf("세션 정보: " + principalDetails.getUser());

        //2. 굳이(?) 심지어 나는 안 됨 왜지
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PrincipalDetails mPrincialDetails = (PrincipalDetails) auth.getPrincipal();
        System.out.printf("직접 찾은 세션 정보: " + mPrincialDetails.getUser());
        return "user/update";
    }
}
