package com.tapzie.services;

import com.tapzie.entities.TapLike;
import com.tapzie.repositories.TapLikeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class TapLikeServiceImpl implements TapLikeService {

    private TapLikeRepository tapLikeRepository;

    @Autowired
    public TapLikeServiceImpl(TapLikeRepository tapLikeRepository) {
        this.tapLikeRepository = tapLikeRepository;
    }

    @Override
    public TapLike save(TapLike tap) {
        return tapLikeRepository.save(tap);
    }

    @Override
    public void delete(Long id) {
        tapLikeRepository.deleteById(id);
    }

    @Override
    public Integer likesCountByuserId(Long userId, Long tapId) {
        return tapLikeRepository.likesCountByuserId(userId, tapId);
    }

    @Override
    public Long getLikeId(Long userId, Long tapId) {
        return tapLikeRepository.getLikeId(userId, tapId);
    }
}
