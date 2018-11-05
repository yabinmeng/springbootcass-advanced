package com.ymeng;

import com.ymeng.model.Customer;
import com.ymeng.model.CustomerAddress;
import com.ymeng.model.Hotel;
import com.ymeng.service.CustomerService;
import com.ymeng.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.lang.System.exit;
import static java.lang.System.out;

@SpringBootApplication
public class MySpringBootTestCmd implements CommandLineRunner {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private CustomerService customerService;

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(MySpringBootTestCmd.class);

        //disabled banner, don't want to see the spring logo
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        //HotelTest();

        CustomerTest();

        exit(0);
    }


    public void HotelTest() {
        out.println("\n=== Delete all existing hotels, if any. ===");
        hotelService.deleteAllHotels();;

        out.println("\n=== Create a few hotels ===");

        UUID hotelId1 = UUID.randomUUID();
        Hotel hotel1 = new Hotel("homewood linconshire");
        Hotel hotel2 = new Hotel(
            hotelId1,
            "hilton double tree sandiego",
            "7450 Hazard Center Dr, San Diego, CA",
            "92108");

        hotelService.createHotel(hotel1);
        hotelService.createHotel(hotel2);

        out.println("\n=== Find a hotel by ID ===");

        Optional<Hotel> foundHotel = hotelService.findHotelByID(hotelId1);
        if (foundHotel.get() == null) {
            out.println("Couldn't find hotel with ID: " + hotelId1.toString());
        }
        else {
            out.println("Found hotel: " + foundHotel.get().toString());
        }

        out.println("\n=== Find all hotels ===");
        List<Hotel> hotels = new ArrayList<Hotel>();
        hotelService.findAllHotels().forEach(e -> hotels.add(e));

        for (Hotel hotel : hotels) {
            out.println("Hotel: " + hotel.toString());
        }
    }

    public void CustomerTest() {

        out.println("\n=== Create a customer ===");

        UUID custId1 = UUID.randomUUID();

        CustomerAddress custAddr = new CustomerAddress(
            "1023 Washington Dr.",
            "CoolCity",
            "Texas",
            "76010"
        );

        Customer customer1 = new Customer(
            custId1, "John", "Doe", "999-101-3456",
            custAddr, LocalDate.of(2011, 10, 5) );

        customerService.createCustomer(customer1);
    }
}
