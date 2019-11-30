package com.tapzie.repositories;

import com.tapzie.entities.Tap;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Created by Justin Lange on 1/10/17.
 */
public interface TapRepository extends CrudRepository<Tap, Long> {
    @Query("SELECT t FROM Tap t WHERE t.userId=?1 ORDER BY t.createdDate DESC")
    List<Tap> findByUserId(Long id);

    @Query("SELECT t FROM Tap t ORDER BY t.createdDate DESC")
    List<Tap> findAll();

    @Transactional
    @Modifying
    @Query("UPDATE Tap t SET t.likes=t.likes+1 WHERE t.id=?1")
    void addLike(Long tapId);

    @Transactional
    @Modifying
    @Query("UPDATE Tap t SET t.likes=t.likes-1 WHERE t.id=?1")
    void removeLike(Long tapId);
}
