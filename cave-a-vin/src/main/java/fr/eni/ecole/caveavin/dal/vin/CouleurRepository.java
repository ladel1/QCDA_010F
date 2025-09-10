package fr.eni.ecole.caveavin.dal.vin;

import fr.eni.ecole.caveavin.bo.vin.Couleur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouleurRepository extends JpaRepository<Couleur,Integer> {
}
