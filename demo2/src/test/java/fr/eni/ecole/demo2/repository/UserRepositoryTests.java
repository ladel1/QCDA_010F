package fr.eni.ecole.demo2.repository;

import fr.eni.ecole.demo2.entity.Profile;
import fr.eni.ecole.demo2.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void ajotuerUserTest(){
        // Arrange
        String username="gaelle987";
        String firstname="Gaelle";

        Profile p1 = Profile.builder()
                .firstname(firstname)
                .lastname("Chevalier")
                .age(29)
                .build();
        User u1 = User.
                builder()
                .username(username)
                .build();

        // Act
        u1.setProfile(p1);
        userRepository.save(u1);
        User fetchedUser = userRepository.findByUsername(username);
        // Assert
        Assertions.assertNotNull(fetchedUser);
        Assertions.assertEquals(fetchedUser.getUsername(),username);
        Assertions.assertEquals(fetchedUser.getProfile().getFirstname(),firstname);

    }

}
