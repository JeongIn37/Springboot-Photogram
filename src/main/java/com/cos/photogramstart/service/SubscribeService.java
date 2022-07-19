package com.cos.photogramstart.service;

import com.cos.photogramstart.domain.subscribe.SubscribeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;


    @Transactional  // insert, delete 등 DB에 영향을 줌
    public void 구독하기(int fromUserId, int toUserId){

        subscribeRepository.save(null);

    }

    @Transactional
    public void 구독취소하기(int fromUserId, int toUserId){

    }
}
