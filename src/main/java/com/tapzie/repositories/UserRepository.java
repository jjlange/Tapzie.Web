package com.tapzie.repositories;

import com.tapzie.entities.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by Justin Lange on 1/10/17.
 */
public interface UserRepository extends CassandraRepository<User, UUID> {
    @Query("SELECT COUNT(*) FROM users WHERE email=?0")
    Integer userRowCountByEmail(String email);

    @Query("SELECT COUNT(*) FROM users WHERE password=?0")
    Integer userRowCountByPassword(String password);

    @Query("SELECT COUNT(*) FROM users WHERE authkey=?0")
    Integer userRowCountByAuthKey(String authkey);

    @Query("SELECT * FROM users WHERE authkey=?0")
    User findByAuthKey(String authkey);

    @Query("SELECT id FROM users WHERE email=?0")
    UUID  userIdByEmail(String email);
}
