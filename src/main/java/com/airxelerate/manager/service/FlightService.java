package com.airxelerate.manager.service;

import com.airxelerate.manager.entity.Flight;

public interface FlightService {

    Flight add(Flight category);

    Flight deleteById(Integer id);

    Iterable<Flight> getAll();

    Flight update(Flight flight);

    Flight getById(int mountainId);

    Iterable<Flight> getAllByOriginAirportCode(String originAirportCode);

}
