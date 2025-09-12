package fr.eni.ecole.caveavin.dal.client;

import fr.eni.ecole.caveavin.bo.client.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,String> {
    Utilisateur findByPseudo(String pseudo);
    Utilisateur findByPseudoAndPassword(String pseudo, String password);
}
