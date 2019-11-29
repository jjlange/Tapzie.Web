package com.tapzie.repositories;

import com.tapzie.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Justin Lange on 1/10/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT COUNT(id) FROM User u WHERE u.email=?1")
    Integer userRowCountByEmail(String email);

    @Query("SELECT COUNT(id) FROM User u  WHERE u.password=?1")
    Integer userRowCountByPassword(String password);

    @Query("SELECT COUNT(id) FROM User u  WHERE u.authkey=?1")
    Integer userRowCountByAuthKey(String authkey);

    @Query("FROM User u WHERE u.authkey=?1")
    User findByAuthKey(String authkey);

    @Query("SELECT COUNT(id) FROM User u  WHERE u.username=?1")
    Integer userRowCountByUsername(String username);

    @Query("SELECT id FROM User u  WHERE u.email=?1")
    Long  userIdByEmail(String email);
}
