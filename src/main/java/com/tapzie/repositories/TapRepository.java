package com.tapzie.repositories;

import com.tapzie.entities.Tap;
import com.tapzie.entities.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Justin Lange on 1/10/17.
 */
public interface TapRepository extends CassandraRepository<Tap, UUID> {
    @Query("SELECT * FROM taps WHERE userid=?0 ORDER BY createdDate DESC;")
    List<Tap> findByUserId(UUID id);
}
