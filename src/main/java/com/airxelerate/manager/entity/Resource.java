package com.airxelerate.manager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public interface Resource {

    @Id
    Integer getId();
    void setId(Integer id);
}
