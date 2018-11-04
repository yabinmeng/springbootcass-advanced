package com.ymeng.service;

import com.ymeng.model.Hotel;
import com.ymeng.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public HotelService() {

    }

    public Optional<Hotel> findHotelByID(UUID id ) {
        return hotelRepository.findById(id);
    }

    public Collection<Hotel> findAllHotels() {
        return hotelRepository.findAll();
    }

    public void saveHotel(Hotel hotel) {
        hotelRepository.insert(hotel);
    }
}
