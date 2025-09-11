package fr.eni.ecole.demovehicule.repository.tableperclass;

import fr.eni.ecole.demovehicule.entity.tableperclass.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
