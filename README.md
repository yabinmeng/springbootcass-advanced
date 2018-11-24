# Overivew 
This repository is **The second scenario of** a seriers of code templates(examples) to demonstrate how to use java Spring framework for data access (insert/update/delete/read) with Cassandra NoSQL database. This series contains the following scenarios:

[Scenario 1]:  Use *Spring Boot* and *Spring Data for Cassandra* for basic CRUD operations (single-column primary key) on simple data types (text, int, etc.) through Rest APIs: https://github.com/yabinmeng/springbootcass-basic

   For this scenario, there is NO special configuration for Cassandra such as user authentication or client-to-server SSL/TLS encyption, etc.

**[Scnenario 2]**: Use ***Spring Boot*** and ***Spring Data for Cassandra*** for more advanced CRUD operations (composite primary key) on more complex data types (UDTs, collections, blobs, etc.) through command line interface: https://github.com/yabinmeng/springbootcass-advanced 

   For this scenario, user autentication is enabled for Cassandra.

[Scenario 3]: Use *Spring Boot* and *DataStax Enterprise Java Driver* to take full potentials of all advanced features as provided by the DataStax driver APIs that are not avaible through Spring Data for Cassandra (or at least in simple and straightforward way), such as flexible load balancing policy, retry policy, connection pooling, more robust object mapping, and a lot more: https://github.com/yabinmeng/springbootcass-dseent 

   For this scenario, user authentication and client-to-server SSL/TLS encryption are both enabled for Cassandra.

---

Please **NOTE** that for all scenarios, 
1) DataStax Enterprise (DSE) version 5.1.11 is used as the Cassandra database.
2) Spring Boot version 2.1.o is used 

Among these scenarios, **Scenario 3 of using Spring Boot and DataStastx Enterprise Java Driver is the recommended approach**. The first 2 approaches, due to its usage with Spring Data for Cassandra, have some limititations that can't be easily addressed and may cause some issues (e.g. unnecessary tombstones) when interacting with Cassandra.

---

# More Notes

The code project structure and Cassandra data acccess API of this scenario are similar to those of the first scenario of this series (of using Spring framework to access Cassandra data) except:

1. Instead of exposing the data access capaibility to Cassandra through Rest APIs, this scenario uses Spring Boot command line interface for testing purose. 

2. In this scenario, DSE user authentication is enabled. In order to connect to the DSE cluster correctly, Spring Boot "application.properties" file needs to have the following extra properties defined:
```
spring.data.cassandra.username = <cassandra_username>
spring.data.cassandra.password = <cassandra_password>
```
3. This scenario deals with the following more complex Cassandra schema elements:
* Composite primary key - multiple columns as the partition key and the clustering key
* User defined type (UDT)
* Collection data types (set and map)
* Blob data type
* Tuple data type
