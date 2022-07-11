package com.cos.photogramstart.domain.user.subscribe;

import com.cos.photogramstart.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder // User <- SignupDto 넣기 위해 사용
@AllArgsConstructor // 전체 생성자
@NoArgsConstructor  // 빈 생성자
@Data   // Getter & Setter
@Entity // DB에 테이블 생성
@Table( // 데이터쌍을 unique로 처리하고 싶을 때 사용
        uniqueConstraints = {
                @UniqueConstraint(
                        name="subscribe_uk",
                        columnNames = {"fromUserId", "toUserId"}    // 실제 테이블의 컬럼명
                )
        }
)
public class Subscribe {

    @Id // pk 생성
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 DB를 따라감 (mysql-AutoIncrement, oracle-sequence )
    private int id;

    @ManyToOne
    @JoinColumn(name = "fromUserId")    // 지정 안 하면 _ 형식으로 자동 생성(ex.from_user_id)
    private User fromUser;

    @ManyToOne
    @JoinColumn(name = "toUserId")
    private User toUser;

    private LocalDateTime createDate;

    @PrePersist // DB에 insert 되기 직전에 실행
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }
}
