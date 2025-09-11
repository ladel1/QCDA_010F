package fr.eni.ecole.demo2.repository.many2many;

import fr.eni.ecole.demo2.entity.many2many.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormateurRepository extends JpaRepository<Formateur,Long> {
}
