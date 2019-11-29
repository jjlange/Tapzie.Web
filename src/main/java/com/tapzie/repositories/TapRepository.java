package com.tapzie.repositories;

import com.tapzie.entities.Tap;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 * Created by Justin Lange on 1/10/17.
 */
public interface TapRepository extends CrudRepository<Tap, Long> {
    @Query("SELECT t FROM Tap t WHERE t.userId=?1")
    List<Tap> findByUserId(Long id);

    /*@Query("SELECT t.content, t.createdDate, t.userId, u.firstName FROM Tap t INNER JOIN User u ON u.id = t.userId")
    List<Tap> findAll(); -- not working yet --*/
}
