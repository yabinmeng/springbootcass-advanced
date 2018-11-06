package com.ymeng.model;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.LocalDate;

@PrimaryKeyClass
public class FlightKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKeyColumn(name = "airline_code", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @Column(value = "airline_code")
    private String airlineCode;

    @PrimaryKeyColumn(name = "flight_no", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    @Column(value = "flight_no")
    private String flightNo;

    @PrimaryKeyColumn(name = "flight_date", ordinal = 2, ordering = Ordering.DESCENDING, type = PrimaryKeyType.CLUSTERED)
    @Column(value = "flight_date")
    private LocalDate flightDate;

    public FlightKey() {}

    public FlightKey(String airlinecode, String flightno, LocalDate flightdate) {
        this.airlineCode = airlinecode;
        this.flightNo = flightno;
        this.flightDate = flightdate;
    }

    public String getAirlineCode() { return this.airlineCode; }
    public void setAirlineCode(String code) { this.airlineCode = code; }

    public String getFlightNo() { return this.flightNo; }
    public void setFlightNo(String no) { this.flightNo = no; }

    public LocalDate getFlightDate() { return this.flightDate; }
    public void setFlightDate(LocalDate date) { this.flightDate = date;     }
}
