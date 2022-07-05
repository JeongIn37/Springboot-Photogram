package com.cos.photogramstart.service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service    //1.Ioc 등록 2.트랜잭션 관리
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder; //비밀번호 암호화용

    @Transactional  //함수가 실행되고 종료될 때까지 트랜잭션 관리. Write(Insert, Update, Delete) 할 때 사용₩
    public User 회원가입(User user){
        // 회원가입 진행 (레포지토리 필요)
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword); //비밀번호 암호화
        user.setPassword(encPassword);
        user.setRole("ROLE_USER");  // 기본 역할 부여. 관리자: ROLE_ADMIN
        User userEntity = userRepository.save(user);
        return userEntity;
    }
}
