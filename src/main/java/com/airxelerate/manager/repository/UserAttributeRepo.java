package com.airxelerate.manager.repository;

import com.airxelerate.manager.entity.UserAttribute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAttributeRepo extends CrudRepository<UserAttribute, Integer> {
    Optional<UserAttribute> findByUsername(String username);
}
