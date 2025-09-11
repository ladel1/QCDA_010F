package fr.eni.ecole.demovehicule.repository.singletable;

import fr.eni.ecole.demovehicule.entity.singletable.Bateau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BateauRepository extends JpaRepository<Bateau,Long> {
}
