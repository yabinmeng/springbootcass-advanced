package com.ymeng;

import com.ymeng.model.Hotel;
import com.ymeng.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;
import static java.lang.System.out;

@SpringBootApplication
public class MySpringBootTestCmd implements CommandLineRunner {

    @Autowired
    private HotelService hotelService;

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(MySpringBootTestCmd.class);

        //disabled banner, don't want to see the spring logo
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        out.println("=== Create a few hotels ===");

        Hotel hotel1 = new Hotel("homewood linconshire");
        Hotel hotel2 = new Hotel("hilton double tree sandiego");

        hotelService.saveHotel(hotel1);
        hotelService.saveHotel(hotel2);

        exit(0);
    }
}
