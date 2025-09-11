package fr.eni.ecole.caveavin.dal.client;

import fr.eni.ecole.caveavin.bo.client.Client;
import fr.eni.ecole.caveavin.bo.client.Proprio;
import fr.eni.ecole.caveavin.bo.client.Utilisateur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class TestHeritage {
//    @Autowired
//    private TestEntityManager entityManager;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    ProprioRepository proprioRepository;

    @Autowired
    ClientRepository clientRepository;

    @BeforeEach
    public void initDB() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        utilisateurs.add(Utilisateur
                .builder()
                .pseudo("harrisonford@email.fr")
                .password("IndianaJones3")
                .nom("Ford")
                .prenom("Harrison")
                .build());

        utilisateurs.add(Proprio
                .builder()
                .pseudo("georgelucas@email.fr")
                .password("Réalisateur&Producteur")
                .nom("Lucas")
                .prenom("George")
                .siret("12345678901234")
                .build());

        utilisateurs.add(Client
                .builder()
                .pseudo("natalieportman@email.fr")
                .password("MarsAttacks!")
                .nom("Portman")
                .prenom("Natalie")
                .build());

        // Contexte de la DB
        utilisateurs.forEach(e -> {
            utilisateurRepository.save(e);
        });
    }

    @Test
    void test_findall_utilisateur(){
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        Assertions.assertNotNull(utilisateurs);
        Assertions.assertEquals(3,utilisateurs.size());
        System.out.println(utilisateurs);
    }

    @Test
    void test_findall_proprio(){
        List<Proprio> proprios = proprioRepository.findAll();
        Assertions.assertNotNull(proprios);
        Assertions.assertEquals(1,proprios.size());
        System.out.println(proprios);
    }

    @Test
    void test_findall_client(){
        List<Client> clients = clientRepository.findAll();
        Assertions.assertNotNull(clients);
        Assertions.assertEquals(1,clients.size());
        System.out.println(clients);
    }

}
