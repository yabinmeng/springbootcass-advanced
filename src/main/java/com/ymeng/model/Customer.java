package com.ymeng.model;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Table(value = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private UUID id;

    @Column(value = "fname")
    private String first_name;

    @Column(value = "lname")
    private String last_name;

    private String phone;

    @CassandraType(type = DataType.Name.UDT, userTypeName = "custaddrtype")
    private CustomerAddress address;

    private LocalDate member_date;

    public Customer(UUID id, String fname, String lame, String phone,
                    CustomerAddress address, LocalDate member_date) {
        this.id = id;
        this.first_name = fname;
        this.last_name = lame;
        this.phone = phone;
        this.address = address;
        this.member_date = member_date;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public void setFirstName(String fname) {
        this.first_name = fname;
    }

    public String getLastName() {
        return this.last_name;
    }

    public void setLastName(String lname) {
        this.last_name = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CustomerAddress getAddress() {
        return address;
    }

    public void setAddress(CustomerAddress address) {
        this.address = address;
    }

    public LocalDate getMemberDate() {
        return member_date;
    }

    public void setMemberDate(LocalDate member_date) {
        this.member_date = member_date;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String memberDateStr = member_date.format(formatter);

        return String.format(
            "{ id = %2$s, name = %3$s %4$s, phone = %5$s, birth_date = %6$s, " +
                " address = %7$s, member_date = %8$s}",
            getClass().getName(), getId(), getFirstName(), getLastName(),
            getPhone(), getAddress().toString(), memberDateStr);
    }
}
