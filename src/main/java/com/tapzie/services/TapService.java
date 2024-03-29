package com.tapzie.services;

import com.tapzie.commands.TapForm;
import com.tapzie.commands.UserForm;
import com.tapzie.entities.Tap;
import com.tapzie.entities.User;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 1/10/17.
 */
public interface TapService {
    List<Tap> findByUserId(Long id);
    List<Tap> listAll();

    Tap save(Tap tap);

    /* Add / remove like func. */
    void addLike(Long tapId);
    void removeLike(Long tapId);
}
