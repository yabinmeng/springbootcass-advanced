CREATE KEYSPACE IF NOT EXISTS testks WITH replication =
    {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;


CREATE TYPE IF NOT EXISTS testks.address_type (
    street text,
    city text,
    state text,
    zipcode text
);

CREATE TABLE IF NOT EXISTS testks.customer (
    id uuid,
    fname text,
    lname text,
    address address_type,
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