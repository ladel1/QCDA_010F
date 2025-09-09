package fr.eni.ecole.demolombok;

import fr.eni.ecole.demolombok.entity.User;
import org.springframework.boot.CommandLineRunner;

public class Boot implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        User alice = User.builder()
                .username("alice23")
                .email("alice23@gmail.com")
                .password("kshfsd54fsd654f@")
                .build();

    }
}
