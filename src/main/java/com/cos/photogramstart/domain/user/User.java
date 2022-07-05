package com.cos.photogramstart.domain.user;

// JPA - Java Persistence API (자바로 데이터를 영구적으로 저장할 수 있는 API를 제공)

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder // User <- SignupDto 넣기 위해 사용
@AllArgsConstructor // 전체 생성자
@NoArgsConstructor  // 빈 생성자
@Data   // Getter & Setter
@Entity // DB에 테이블 생성
public class User {

    @Id // pk 생성
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 DB를 따라감 (mysql-AutoIncrement, oracle-sequence )
    private int id;

    @Column(unique = true)
    private String username;
    private String password;

    private String name;
    private String website; // 웹 사이트
    private String bio; // 자기소개
    private String email;
    private String phone;
    private String gender;

    private String profileImageUrl; // 사진
    private String role;    // 권한

    private LocalDateTime createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // create date 자동 생성
    @PrePersist // DB에 insert 되기 직전에 실행
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }
}
