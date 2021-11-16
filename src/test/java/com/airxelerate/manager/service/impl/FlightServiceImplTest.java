package com.airxelerate.manager.service.impl;

import com.airxelerate.manager.entity.Flight;
import com.airxelerate.manager.exception.FlightNotFoundException;
import com.airxelerate.manager.repository.FlightRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FlightServiceImplTest {

    @Mock
    FlightRepo flightRepo;

    @InjectMocks
    FlightServiceImpl flightService;

    @Test
    void getByIdNotFound() {
        int id = 1;

        when(flightRepo.findById(id)).thenReturn(Optional.empty());
        assertThrows(FlightNotFoundException.class, () -> flightService.getById(1));

        verify(flightRepo).findById(id);
    }

    @Test
    void getById() {
        int id = 1;
        Optional<Flight> flight = Optional.of(new Flight());
        when(flightRepo.findById(id)).thenReturn(flight);

        var result = flightService.getById(1);
        assertNotNull(result);

        verify(flightRepo).findById(id);
    }
}