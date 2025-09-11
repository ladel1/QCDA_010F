package fr.eni.ecole.demovehicule.repository.tableperclass;

import fr.eni.ecole.demovehicule.entity.tableperclass.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
}
