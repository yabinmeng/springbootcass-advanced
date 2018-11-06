package com.ymeng.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Table("flight")
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private FlightKey flightKey;

    @Column(value = "seat_map_pic")
    private ByteBuffer seatMapPic;

    @Column(value = "crew_names")
    private HashSet<String> crewNames;

    @Column(value = "section_seats")
    private HashMap<String, Integer> sectionSeats;

    private FlightMiscNote misc_notes;

    /**
     * Need the default, no-argument constructor in order
     * for Spring Cassandra findXXX() functions to work
     */
    public Flight() {}

    public Flight(FlightKey flightKey) {
        this.flightKey = flightKey;
    }

    public Flight(String airlinecode, String flightno, LocalDate flightdate) {
        this(new FlightKey(airlinecode, flightno, flightdate));
    }

    public FlightKey getFlightKey() { return this.flightKey; }
    public void setFlightKey(FlightKey flightKey) { this.flightKey = flightKey; }

    public ByteBuffer getSeatMapPic() { return this.seatMapPic; }
    public void setSeatMapPic(ByteBuffer pic) { this.seatMapPic = pic; }

    public HashSet<String> getCrewNames() { return crewNames; }
    public void setCrewNames(HashSet<String> crewNames) { this.crewNames = crewNames; }

    public HashMap<String, Integer> getSectionSeats() { return this.sectionSeats; }
    public void setSectionSeats(HashMap<String, Integer> sectionSeats) { this.sectionSeats = sectionSeats; }

    public FlightMiscNote getMiscNotes() { return this.misc_notes; }
    public void setMiscNotes(FlightMiscNote miscNotes) { this.misc_notes = miscNotes; };

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{ ");

        String flightKeyStr = String.format(
            "((airline_code = %1$s, flight_no = %2$s), flight_date = %3$s) : ",
            getFlightKey().getAirlineCode(), getFlightKey().getFlightNo(), getFlightKey().getFlightDate() );
        stringBuilder.append(flightKeyStr);

        if ( getSeatMapPic() != null ) {
            stringBuilder.append("Seat Map Pic (" + getSeatMapPic().toString() + ")");
            stringBuilder.append("; ");
        }

        if ( getCrewNames() != null ) {
            String crewNameString = "Crew Names [";
            int i = 0;
            for (String name : getCrewNames()) {
                crewNameString += name;
                i++;
                if (i < getCrewNames().size()) {
                    crewNameString += ", ";
                }
            }
            crewNameString += "]";
            stringBuilder.append(crewNameString);
            stringBuilder.append("; ");
        }

        if ( getSectionSeats() != null ) {
            String sectionSeatString = "Section Seats {";
            Set<String> sections = getSectionSeats().keySet();
            int j = 0;
            for (String section : sections) {
                sectionSeatString += section + ":" + getSectionSeats().get(section).intValue();
                j++;
                if (j < sections.size()) {
                    sectionSeatString += ", ";
                }
            }
            sectionSeatString += "}";
            stringBuilder.append(sectionSeatString);
            stringBuilder.append("; ");
        }

        if ( getMiscNotes() != null ) {
            stringBuilder.append("Misc Notes (" + getMiscNotes().toString() + ")");
        }

        stringBuilder.append(" }");

        return stringBuilder.toString();
    }
}
