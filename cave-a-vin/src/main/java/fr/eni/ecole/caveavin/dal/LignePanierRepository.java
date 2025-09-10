package fr.eni.ecole.caveavin.dal;

import fr.eni.ecole.caveavin.bo.client.LignePanier;
import fr.eni.ecole.caveavin.bo.client.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LignePanierRepository extends JpaRepository<LignePanier,Integer> {
}
