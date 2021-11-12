package com.airxelerate.manager.repository;

import com.airxelerate.manager.entity.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepo<E extends Resource> extends CrudRepository<E, Integer> {
}
