package fr.eni.ecole.caveavin.dal.vin;

import fr.eni.ecole.caveavin.bo.vin.Bouteille;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BouteilleRepository extends JpaRepository<Bouteille,Integer> {
}
