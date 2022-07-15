package com.cos.photogramstart.service;

import com.cos.photogramstart.domain.user.subscribe.Subscribe;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubscribeService {

    @Transactional  // insert, delete 등 DB에 영향을 줌
    public void 구독하기(int fromUserId, int toUserId){

    }

    @Transactional
    public void 구독취소하기(int fromUserId, int toUserId){

    }
}
