package fr.eni.ecole.demo2.repository;

import fr.eni.ecole.demo2.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
    Profile findByFirstname(String firstname);
}
