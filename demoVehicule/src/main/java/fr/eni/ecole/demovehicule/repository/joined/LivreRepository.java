package fr.eni.ecole.demovehicule.repository.joined;

import fr.eni.ecole.demovehicule.entity.joined.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre,Long> {
}
