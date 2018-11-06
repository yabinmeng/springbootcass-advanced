package com.ymeng.model;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Element;
import org.springframework.data.cassandra.core.mapping.Tuple;

import java.io.Serializable;

@Tuple
public class FlightMiscNote implements Serializable {

    private static final long serialVersionUID = 1L;

    @Element(0)
    @CassandraType(type = DataType.Name.VARCHAR)
    private String sourceCity;

    @Element(1)
    private String destCity;

    @Element(2)
    @CassandraType(type = DataType.Name.FLOAT)
    private Float distance;

    public FlightMiscNote() {}

    public FlightMiscNote(String source, String dest, Float dist) {
        this.sourceCity = source;
        this.destCity = dest;
        this.distance = dist;
    }

    public String getSourceCity() { return this.sourceCity; }
    public void setSourceCity(String source) { this.sourceCity = source; }

    public String getDestCity() { return this.destCity; }
    public void setDestCity(String dest) { this.destCity = dest; }

    public Float getDistance() { return this.distance; }
    public void setDistance(Float dist) { this.distance = dist; }

    public String toString() {
        return String.format(
            "{ sourceCity = %1$s, destCity = %2$s, distance = %3$s }",
            getSourceCity(), getDestCity(), getDistance());
    }
}
