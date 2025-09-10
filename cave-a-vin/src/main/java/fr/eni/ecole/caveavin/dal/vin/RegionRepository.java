package fr.eni.ecole.caveavin.dal.vin;

import fr.eni.ecole.caveavin.bo.vin.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region,Integer> {
}
