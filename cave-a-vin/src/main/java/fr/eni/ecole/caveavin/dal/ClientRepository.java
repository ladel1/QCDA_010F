package fr.eni.ecole.caveavin.dal;

import fr.eni.ecole.caveavin.bo.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,String> {
    Client findByPseudo(String pseudo);
}
