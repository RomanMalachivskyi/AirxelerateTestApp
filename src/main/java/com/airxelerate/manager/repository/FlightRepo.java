package com.airxelerate.manager.repository;

import com.airxelerate.manager.entity.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends CrudRepository<Flight, Integer> {
    Iterable<Flight> findByOriginAirportCode(String originAirportCode);
}
