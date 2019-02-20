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
        HashSet set1 = new HashSet();
        set1.add(Role.ROLE_USER);
        HashSet set2 = new HashSet();
        set2.add(Role.ROLE_USER);
        set2.add(Role.ROLE_ADMIN);
        userRepository.save(new User("user@gmail.com", "User_First", "User_Last", "password", set1));
        userRepository.save(new User("admin@javaops.ru", "Admin_First", "Admin_Last", "admin", set2));
        System.out.println(userRepository.findAll());
    }
}
