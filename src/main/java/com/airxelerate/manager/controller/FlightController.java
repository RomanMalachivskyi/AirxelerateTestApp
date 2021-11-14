package com.airxelerate.manager.controller;

import com.airxelerate.manager.entity.Flight;
import com.airxelerate.manager.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @RequestMapping(value = "/{flightId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('ADMIN', 'READ_ONLY')")
    public Flight getById(final @PathVariable int flightId) {
        return flightService.getById(flightId);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('ADMIN', 'READ_ONLY')")
    public Iterable<Flight> getAll() {
        return flightService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, params = {"originAirportCode"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('ADMIN', 'READ_ONLY')")
    public Iterable<Flight> getAllByOriginAirportCode(@RequestParam String originAirportCode) {
        return flightService.getAllByOriginAirportCode(originAirportCode);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Flight addNewFlight(@RequestBody @Valid final Flight flight) {
        return flightService.add(flight);
    }

    @RequestMapping(value = "/{flightId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Flight modify(@RequestBody @Valid final Flight flight, final @PathVariable int flightId) {
        return flightService.update(flight);
    }

    @RequestMapping(value = "/{flightId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Flight delete(final @PathVariable int flightId) {
        return flightService.deleteById(flightId);
    }
}
