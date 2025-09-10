package fr.eni.ecole.caveavin.dal.client;

import fr.eni.ecole.caveavin.bo.client.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class ClientRepositoryTests {

    @Autowired
    private ClientRepository clientRepository;


    @Test
    public void sauverClientTest(){
        // Arrange
        String pseudo = "lucas25";
        String nom = "Maisel";

        Client lucas = Client
                .builder()
                .nom(nom)
                .prenom("Lucas")
                .pseudo(pseudo)
                .password("65498dff4gf6d54@")
                .build();

        // Act
        clientRepository.save(lucas);

        Client savedLucas = clientRepository.findByPseudo(pseudo);

        // Assert
        Assertions.assertNotNull(savedLucas);
        Assertions.assertEquals(savedLucas.getNom(),nom);

        System.out.println(savedLucas);
    }

    @Test
    public void supprimerClientTest(){
        // Arrange
        String pseudo = "sarah29";
        String nom = "Chevalier";

        Client sarah = Client
                .builder()
                .nom(nom)
                .prenom("Sarah")
                .pseudo(pseudo)
                .password("sdjfhgsdfg@")
                .build();
        //  ajouter dans la bdd
        clientRepository.save(sarah);
        // chercher le client
        Client savedClient = clientRepository.findByPseudo(pseudo);
        // suppression
        clientRepository.delete(savedClient);
        Client supressedClient = clientRepository.findByPseudo(pseudo);
        // Assert
        Assertions.assertNull(supressedClient);
    }

}
