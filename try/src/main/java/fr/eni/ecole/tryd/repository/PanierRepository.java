package fr.eni.ecole.tryd.repository;

import fr.eni.ecole.tryd.bo.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepository extends JpaRepository<Panier,Long> {
}
