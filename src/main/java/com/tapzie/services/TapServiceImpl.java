package com.tapzie.services;


import com.tapzie.converters.UserFormToUser;
import com.tapzie.entities.Tap;
import com.tapzie.repositories.TapRepository;
import com.tapzie.repositories.UserRepository;
import com.tapzie.commands.UserForm;
import com.tapzie.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class TapServiceImpl implements TapService {

    private TapRepository tapRepository;

    @Autowired
    public TapServiceImpl(TapRepository tapRepository) {
        this.tapRepository = tapRepository;
    }


    @Override
    public List<Tap> findByUserId(Long id) {
        return tapRepository.findByUserId(id);
    }


    @Override
    public Tap save(Tap tap) {
        return tapRepository.save(tap);
    }

}
