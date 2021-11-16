package com.airxelerate.manager.service;

import com.airxelerate.manager.entity.UserAttribute;
import com.airxelerate.manager.exception.UserAttributeDuplicateException;

public interface UserAttributeService {

    UserAttribute add(UserAttribute userAttribute) throws UserAttributeDuplicateException;

    UserAttribute getByUsername(String username);

    Iterable<UserAttribute> getAll();
}
