package com.airxelerate.manager.controller;

import com.airxelerate.manager.entity.Flight;
import com.airxelerate.manager.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    FlightService flightService;

    @RequestMapping(value = "/{mountainId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Flight getById(final @PathVariable int mountainId) {
        return flightService.getById(mountainId);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable<Flight> getAll() {
        return flightService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Flight addNewFlight(@RequestBody final Flight flight) {
        return flightService.add(flight);
    }

    @RequestMapping(value = "/{flightId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Flight modify(@RequestBody final Flight mountain, final @PathVariable int flightId) {
        mountain.setId(flightId);
        return flightService.update(mountain);
    }

    @RequestMapping(value = "/{flightId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Flight delete(final @PathVariable int flightId) {
        return flightService.deleteById(flightId);
    }
}
