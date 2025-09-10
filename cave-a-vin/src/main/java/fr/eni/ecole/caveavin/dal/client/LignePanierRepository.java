package fr.eni.ecole.caveavin.dal.client;

import fr.eni.ecole.caveavin.bo.client.LignePanier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LignePanierRepository extends JpaRepository<LignePanier,Integer> {
}
