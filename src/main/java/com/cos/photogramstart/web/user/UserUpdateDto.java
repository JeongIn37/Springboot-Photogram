package com.cos.photogramstart.web.user;

import com.cos.photogramstart.domain.user.User;
import lombok.Data;

@Data
public class UserUpdateDto {
    private String name;    // 필수
    private String password;    // 필수
    //
    private String website;
    private String bio;
    private String phone;
    private String gender;

    public User toEntity() {
        return User.builder()
                .name(name) // 이름 기재 안 했으면 문제 생김 validation check
                .password(password) //패스워드 기재 안 했으면 문제 생김. validation check
                .email(website)
                .bio(bio)
                .phone(phone)
                .gender(gender)
                .build();
    }
}
