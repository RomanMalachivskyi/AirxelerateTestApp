package com.airxelerate.manager.service.impl;

import com.airxelerate.manager.entity.Flight;
import com.airxelerate.manager.exception.FlightException;
import com.airxelerate.manager.exception.FlightNotFoundException;
import com.airxelerate.manager.repository.FlightRepo;
import com.airxelerate.manager.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Iterable<Flight> result = flightRepo.findAll();
        return flightRepo.findAll();
    }

    @Override
    public Flight update(Flight flight) {
        //@TODO
        return null;
    }

    @Override
    public Flight getById(int flightId) {
        return flightRepo.findById(flightId).orElseThrow(FlightNotFoundException::new);
    }
}
