package com.ymeng.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Table("hotel")
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private UUID id;

    private String name;
    private String address;
    private String zip;

    /**
     * Need the default, no-argument constructor in order
     * for Spring Cassandra findXXX() functions to work
     */
    public Hotel() {
    }

    public Hotel(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Hotel(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public Hotel(String name, String address, String zip) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.address = address;
        this.zip = zip;
    }

    public Hotel(UUID id, String name, String address, String zip) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.zip = zip;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id =id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return this.zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return String.format(
            "{ ID = %1$s, name = %2$s, address = %3$s, zip = %4$s }",
            getId(), getName(), getAddress(), getZip());
    }
}
