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
public class ProfileRepositoryTests {

    @Autowired
    private ProfileRepository profileRepository;


    @Transactional
    @Test
    void ajouterProfileAvecUserTest(){

        String firstname = "Adel";

        User user = User.builder()
                .username("adel23")
                .build();
        Profile profile = Profile.builder()
                .user(user)
                .firstname(firstname)
                .lastname("latibi")
                .age(31)
                .build();

        profileRepository.save(profile);

        Profile adel = profileRepository.findByFirstname(firstname);

        Assertions.assertNotNull(adel);
        Assertions.assertEquals(adel.getFirstname(),firstname);

        System.out.println("Username: "+adel.getUser().getUsername());

    }
}
