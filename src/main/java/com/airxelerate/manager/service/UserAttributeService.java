package com.airxelerate.manager.service;

import com.airxelerate.manager.entity.UserAttribute;

public interface UserAttributeService {

    UserAttribute add(UserAttribute category);

    UserAttribute getByUsername(String username);

    Iterable<UserAttribute> getAll();
}
