package com.cos.photogramstart.domain.user.subscribe;

import org.springframework.data.jpa.repository.JpaRepository;

//JPARepository 상속하면 어노테이션이 없어도 자동으로 IoC 등록
public interface SubscribeRepository extends JpaRepository<Subscribe, Integer> {  //<오브젝트, pk의 타입>

}
