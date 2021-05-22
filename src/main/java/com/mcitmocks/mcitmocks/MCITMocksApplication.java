package com.mcitmocks.mcitmocks;

import com.mcitmocks.mcitmocks.User.User;
import com.mcitmocks.mcitmocks.User.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@RestController
public class MCITMocksApplication {

    @GetMapping(path = "/api/test")
    String test() {
        return "test string";
    }

    public static void main(String[] args) {
        SpringApplication.run(MCITMocksApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User mario = new User("mario@seas.upenn.edu", "America/Chicago");
            userRepository.save(mario);
        };
    }
}
