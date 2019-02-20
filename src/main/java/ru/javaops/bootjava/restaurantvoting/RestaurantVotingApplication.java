package ru.javaops.bootjava.restaurantvoting;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.javaops.bootjava.restaurantvoting.model.Role;
import ru.javaops.bootjava.restaurantvoting.model.User;
import ru.javaops.bootjava.restaurantvoting.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class RestaurantVotingApplication implements ApplicationRunner {
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantVotingApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(userRepository.findByLastNameContainingIgnoreCase("last"));
    }
}
