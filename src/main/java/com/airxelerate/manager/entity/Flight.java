package com.airxelerate.manager.entity;

import javax.persistence.*;

@Entity
public class Flight implements Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String fromCountry;
    @Column
    private String toCountry;
    @Column
    private String number;

//    public Flight() {
//    }
//
//    public Flight(String fromCountry, String toCountry, String number) {
//        this.fromCountry = fromCountry;
//        this.toCountry = toCountry;
//        this.number = number;
//    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromCountry() {
        return this.fromCountry;
    }

    public void setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry;
    }

    public String getToCountry() {
        return toCountry;
    }

    public void setToCountry(String toCountry) {
        this.toCountry = toCountry;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
