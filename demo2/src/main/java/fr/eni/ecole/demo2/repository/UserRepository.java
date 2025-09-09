package fr.eni.ecole.demo2.repository;

import fr.eni.ecole.demo2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
