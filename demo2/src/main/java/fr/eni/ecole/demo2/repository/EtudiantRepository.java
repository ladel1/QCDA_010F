package fr.eni.ecole.demo2.repository;

import fr.eni.ecole.demo2.entity.Etudiant;
import fr.eni.ecole.demo2.entity.IdEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, IdEtudiant> {
}
