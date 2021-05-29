package com.mcitmocks.mcitmocks;

import com.mcitmocks.mcitmocks.Availability.Availability;
import com.mcitmocks.mcitmocks.User.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

@Configuration
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class })
@ComponentScan
@RestController
public class MCITMocksApplication {

   /* @GetMapping(path = "/api/test")
    String test() {
        return "test string";
    }*/

    public static void main(String[] args) {
        System.out.println(org.hibernate.Version.getVersionString());
        SpringApplication.run(MCITMocksApplication.class, args);

      /*  SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Availability.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();*/
    /*    HibernateAnnotationUtil hibernateAnnotationUtil = new HibernateAnnotationUtil();
         SessionFactory factory =  hibernateAnnotationUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        User user = new User("mario@gmail.com", "America/Chicago");
        System.out.println("saving user: " + user);
        session.save(user);

        String now = ZonedDateTime.now( ZoneOffset.UTC ).format( DateTimeFormatter.ISO_INSTANT );
        Availability availability1 = new Availability(now, true);
        user.addAvailability(availability1);
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        String time2 = df.format(new Date());
        Availability availability2 = new Availability(time2, true);
        user.addAvailability(availability2);
        session.save(availability1);
        session.save(availability2);

        session.delete(availability1);
        session.getTransaction().commit();


        System.out.println("Done!");

    }

   /*@Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User mario = new User("mario@seas.upenn.edu", "America/Chicago");
            userRepository.save(mario);
        };*/
    }
    }
