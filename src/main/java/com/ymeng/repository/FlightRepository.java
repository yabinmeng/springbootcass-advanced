package com.ymeng.repository;

import com.ymeng.model.Flight;
import com.ymeng.model.FlightKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CassandraRepository<Flight, FlightKey> {

}
