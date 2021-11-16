package com.airxelerate.manager.service.impl;

import com.airxelerate.manager.entity.UserAttribute;
import com.airxelerate.manager.exception.UserAttributeDuplicateException;
import com.airxelerate.manager.exception.UserAttributeNotFoundException;
import com.airxelerate.manager.repository.UserAttributeRepo;
import com.airxelerate.manager.service.UserAttributeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserAttributeServiceImpl implements UserAttributeService {

    @Autowired
    private UserAttributeRepo userAttributeRepo;

    @Override
    public UserAttribute add(UserAttribute userAttribute) throws UserAttributeDuplicateException {
        log.info("add new user: " + userAttribute);
        if (userAttributeRepo.existsByUsername(userAttribute.getUsername())) {
            throw new UserAttributeDuplicateException("user with such username already exists");
        }
        return userAttributeRepo.save(userAttribute);
    }

    @Override
    public UserAttribute getByUsername(String username) {
        log.info("get by username: " + username);
        return userAttributeRepo.findByUsername(username).orElseThrow(() -> new UserAttributeNotFoundException(username));
    }

    @Override
    public Iterable<UserAttribute> getAll() {
        log.info("get all users");
        return userAttributeRepo.findAll();
    }
}
