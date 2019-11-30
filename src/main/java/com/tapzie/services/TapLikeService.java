package com.tapzie.services;

import com.tapzie.commands.TapForm;
import com.tapzie.commands.UserForm;
import com.tapzie.entities.Tap;
import com.tapzie.entities.TapLike;
import com.tapzie.entities.User;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 1/10/17.
 */
public interface TapLikeService {
    void delete(Long id);

    TapLike save(TapLike tap);

    Integer likesCountByuserId(Long userId, Long tapId);
    Long getLikeId(Long userId, Long tapId);
}
