package com.ymeng.repository;

import com.ymeng.model.Hotel;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelRepository extends CassandraRepository<Hotel, UUID> {

}
