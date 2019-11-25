package com.tapzie.converters;

import com.tapzie.commands.UserForm;
import com.tapzie.entities.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by jt on 1/10/17.
 */
@Component
public class UserFormToUser implements Converter<UserForm, User> {

    @Override
    public User convert(UserForm userForm) {
        User user = new User();
        if (userForm.getId() != null  && !StringUtils.isEmpty(userForm.getId())) {
            user.setId(userForm.getId());
        }

        user.setEmail(userForm.getEmail());
        user.setUsername(userForm.getUsername());
        user.setPassword(userForm.getPassword());
        return user;
    }
}
