package com.tapzie.services;


import com.tapzie.entities.Friend;


public interface FriendService {
    Integer friendsCountByuserId(Long userId, Long tapId);

    Friend saveOrUpdate(Friend friend);
}
