package fr.eni.ecole.caveavin.dal;

import fr.eni.ecole.caveavin.bo.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse, Integer>
{
}
