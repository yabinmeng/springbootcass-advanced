package com.ymeng.service;

import com.ymeng.model.Customer;
import com.ymeng.model.Hotel;
import com.ymeng.repository.CustomerRepository;
import com.ymeng.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService() {

    }

    public Optional<Customer> findCustomerByID(UUID id ) {
        return customerRepository.findById(id);
    }

    public void createCustomer(Customer customer) {
        customerRepository.insert(customer);
    }
}
