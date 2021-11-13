package com.airxelerate.manager.service.impl;

import com.airxelerate.manager.entity.Flight;
import com.airxelerate.manager.exception.FlightException;
import com.airxelerate.manager.exception.FlightNotFoundException;
import com.airxelerate.manager.repository.FlightRepo;
import com.airxelerate.manager.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepo flightRepo;

    @Override
    public Flight add(Flight category) {
        return flightRepo.save(category);
    }

    @Override
    public Flight deleteById(Integer id) {
        log.info("delete flight with id: " + id);
        Optional<Flight> categoryToDelete = flightRepo.findById(id);
        if (categoryToDelete.isPresent()){
            flightRepo.deleteById(id);
            return categoryToDelete.get();
        } else {
            throw new FlightException();
        }
    }

    @Override
    public Iterable<Flight> getAll() {
        log.info("get all flights");
        return flightRepo.findAll();
    }

    @Override
    public Flight update(Flight flight) {
       throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public Flight getById(int flightId) {
        log.info("get flight by id: " + flightId);
        return flightRepo.findById(flightId).orElseThrow(() -> new FlightNotFoundException(flightId));
    }

    @Override
    public Iterable<Flight> getAllByOriginAirportCode(String originAirportCode) {
        log.info("get flights by originAirportCode: " + originAirportCode);
        return flightRepo.findByOriginAirportCode(originAirportCode);
    }
}
