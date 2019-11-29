package com.tapzie.services;

import com.tapzie.converters.UserFormToUser;
import com.tapzie.repositories.UserRepository;
import com.tapzie.commands.UserForm;
import com.tapzie.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserFormToUser userFormToUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserFormToUser userFormToUser) {
        this.userRepository = userRepository;
        this.userFormToUser = userFormToUser;
    }


    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add); //fun with Java 8
        return users;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveOrUpdate(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public Integer userCountByEmail(String email) {
        return userRepository.userRowCountByEmail(email);
    }

    @Override
    public Integer userCountByPassword(String password) {
        return userRepository.userRowCountByPassword(password);
    }

    @Override
    public Integer userCountByAuthKey(String authkey) {
        return userRepository.userRowCountByAuthKey(authkey);
    }

    @Override
    public Integer userCountByUsername(String username) {
        return userRepository.userRowCountByUsername(username);
    }

    @Override
    public User findByAuthKey(String authkey) {
        return userRepository.findByAuthKey(authkey);
    }

    @Override
    public Long userIdByEmail(String email) {
        return userRepository.userIdByEmail(email);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public User saveOrUpdateUserForm(UserForm userForm) {
        User savedUser = saveOrUpdate(userFormToUser.convert(userForm));

        System.out.println("Saved User Id: " + savedUser.getId());
        return savedUser;
    }
}
