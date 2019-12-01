package com.tapzie.repositories;

import com.tapzie.entities.Friend;
import com.tapzie.entities.TapLike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Justin Lange on 1/10/17.
 */
public interface FriendRepository extends CrudRepository<Friend, Long> {
    @Query("SELECT COUNT(id) FROM Friend f WHERE f.userId=?1 AND f.friendId=?2 AND f.status=true")
    Integer friendsCountByuserId(Long id, Long userId);
}
