CREATE KEYSPACE IF NOT EXISTS testks WITH replication =
    {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;


CREATE TYPE IF NOT EXISTS testks.CustAddrType (
    street text,
    city text,
    state text,
    zipcode text
);

CREATE TABLE IF NOT EXISTS testks.customer (
    id uuid,
    fname text,
    lname text,
    phone varchar,
    address CustAddrType,
    member_date date,
    primary key ((id))
);

CREATE TABLE IF NOT EXISTS testks.hotel (
    id UUID,
    name varchar,
    address varchar,
    zip varchar,
    primary key((id))
);

CREATE TABLE IF NOT EXISTS testks.flight (
    airline_code text,
    flight_no text,
    flight_date date,
    seat_map_pic blob,
    crew_names set<text>,
    section_seats map<text, int>,
    misc_notes tuple<varchar, text, float>,
    primary key((airline_code,flight_no), flight_date)
);

