package com.tapzie.services;

import com.tapzie.commands.UserForm;
import com.tapzie.entities.User;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 1/10/17.
 */
public interface UserService {

    List<User> listAll();

    User getById(UUID id);

    User saveOrUpdate(User user);

    void delete(UUID id);

    User saveOrUpdateUserForm(UserForm userForm);

    Integer userCountByEmail(String email);

    Integer userCountByPassword(String password);

    Integer userCountByAuthKey(String authkey);

    Integer userCountByUsername(String username);

    User findByAuthKey(String authkey);

    UUID userIdByEmail(String email);

}
