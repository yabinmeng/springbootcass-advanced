package com.ymeng.service;

import com.ymeng.model.Flight;
import com.ymeng.model.FlightKey;
import com.ymeng.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public FlightService() {

    }

    public Optional<Flight> findFlightByKey(FlightKey flightKey) {
        return flightRepository.findById(flightKey);
    }

    public void createFlight(Flight flight) {
        flightRepository.insert(flight);
    }

    public void deleteFlightByKey(FlightKey flightKey) {
        flightRepository.deleteById(flightKey);
    }

    public void deleteFlight(Flight flight) {
        flightRepository.delete(flight);
    }
}