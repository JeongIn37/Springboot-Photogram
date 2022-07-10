package com.cos.photogramstart.web;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @GetMapping("/user/{id}")
    public String profile(@PathVariable int id){    // user별 profile 페이지 이동을 위해 id 추가
        return "user/profile";
    }

    @GetMapping("user/{id}/update")
    public String update(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails){
        //AuthenticationPricinpal: 세션에 접근하기 위해 사용

        // 1. 추천
        System.out.println("세션 정보 : "+principalDetails.getUser());

        // 2. 극혐
        Authentication auth =   SecurityContextHolder.getContext().getAuthentication();
        PrincipalDetails mPrincipalDetails = (PrincipalDetails) auth.getPrincipal();
        System.out.println("직접 찾은 세션 정보 : "+mPrincipalDetails.getUser());

        return "user/update";
    }
}
