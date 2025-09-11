package fr.eni.ecole.demovehicule.repository.singletable;

import fr.eni.ecole.demovehicule.entity.singletable.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture,Long> {
}
