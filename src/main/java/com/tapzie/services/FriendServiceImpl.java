package com.tapzie.services;


import com.tapzie.entities.Friend;
import com.tapzie.entities.User;
import com.tapzie.repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FriendServiceImpl implements FriendService {

    private FriendRepository friendRepository;

    @Autowired
    public FriendServiceImpl(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }


    @Override
    public Integer friendsCountByuserId(Long userId, Long friendId) {
        return friendRepository.friendsCountByuserId(userId, friendId);
    }

    @Override
    public Friend saveOrUpdate(Friend friend) {
        friendRepository.save(friend);
        return friend;
    }
}
