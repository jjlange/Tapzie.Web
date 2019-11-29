package com.tapzie.services;

import com.tapzie.commands.UserForm;
import com.tapzie.entities.User;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface UserService {

    List<User> listAll();

    User getById(Long id);

    User saveOrUpdate(User user);

    void delete(Long id);

    User saveOrUpdateUserForm(UserForm userForm);

    Integer userCountByEmail(String email);

    Integer userCountByPassword(String password);

    Integer userCountByAuthKey(String authkey);

    Integer userCountByUsername(String username);

    User findByAuthKey(String authkey);

    Long userIdByEmail(String email);

}
