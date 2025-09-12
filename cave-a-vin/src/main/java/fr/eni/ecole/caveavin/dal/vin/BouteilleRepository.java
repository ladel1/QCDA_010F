package fr.eni.ecole.caveavin.dal.vin;

import fr.eni.ecole.caveavin.bo.vin.Bouteille;
import fr.eni.ecole.caveavin.bo.vin.Couleur;
import fr.eni.ecole.caveavin.bo.vin.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BouteilleRepository extends JpaRepository<Bouteille,Integer> {

    List<Bouteille> findByRegion(Region region);
    List<Bouteille> findByCouleur(Couleur couleur);

}
