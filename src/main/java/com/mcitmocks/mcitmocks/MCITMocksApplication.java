package com.mcitmocks.mcitmocks;

import com.mcitmocks.mcitmocks.Availability.Availability;
import com.mcitmocks.mcitmocks.User.User;
import com.mcitmocks.mcitmocks.User.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@SpringBootApplication
@RestController
public class MCITMocksApplication {

    @GetMapping(path = "/api/test")
    String test() {
        return "test string";
    }

    public static void main(String[] args) {
        SpringApplication.run(MCITMocksApplication.class, args);
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Availability.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        User user = new User("mario@gmail.com", "America/Chicago");
        System.out.println("saving user: " + user);
        session.save(user);

        OffsetDateTime offsetDT1 = OffsetDateTime.now();
        Availability availability1 = new Availability(offsetDT1, true);
        user.addAvailability(availability1);
        OffsetDateTime offsetDT2 = OffsetDateTime.parse("2019-08-31T15:20:30+08:00");
        Availability availability2 = new Availability(offsetDT2, true);
        user.addAvailability(availability2);
        session.save(availability1);
        session.save(availability2);

        session.delete(availability1);
        session.getTransaction().commit();


        System.out.println("Done!");

    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User mario = new User("mario@seas.upenn.edu", "America/Chicago");
            userRepository.save(mario);
        };
    }
}
