package com.tapzie.repositories;

import com.tapzie.entities.TapLike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Justin Lange on 1/10/17.
 */
public interface TapLikeRepository extends CrudRepository<TapLike, Long> {
    @Query("SELECT COUNT(id) FROM TapLike tl WHERE tl.userId=?1 AND tl.tapId=?2")
    public Integer likesCountByuserId(Long userId, Long tapId);

    @Query("SELECT tl.id FROM TapLike tl WHERE tl.userId=?1 AND tl.tapId=?2")
    public Long getLikeId(Long userId, Long tapId);
}
