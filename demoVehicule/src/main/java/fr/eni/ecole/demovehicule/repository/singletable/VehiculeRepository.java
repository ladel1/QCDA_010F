package fr.eni.ecole.demovehicule.repository.singletable;

import fr.eni.ecole.demovehicule.entity.singletable.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
}
