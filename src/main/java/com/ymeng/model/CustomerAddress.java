package com.ymeng.model;


import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.io.Serializable;

@UserDefinedType(value = "custaddrtype")
public class CustomerAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    private String street;
    private String city;
    private String state;

    @Column(value = "zipcode")
    private String zip;

    public CustomerAddress(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() {
        return this.street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return this.zip;
    }
    public void setZip() {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return String.format(
            "{ street = %2$s, city = %3$s, state = %4$s, zipcode = %5s }",
            getStreet(), getCity(), getState(), getZip()
        );
    }
}