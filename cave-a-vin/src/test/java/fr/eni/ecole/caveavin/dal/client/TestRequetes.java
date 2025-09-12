package fr.eni.ecole.caveavin.dal.client;
import static org.assertj.core.api.Assertions.assertThat;
import fr.eni.ecole.caveavin.bo.client.Client;
import fr.eni.ecole.caveavin.bo.client.Proprio;
import fr.eni.ecole.caveavin.bo.client.Utilisateur;
import fr.eni.ecole.caveavin.bo.vin.Bouteille;
import fr.eni.ecole.caveavin.bo.vin.Couleur;
import fr.eni.ecole.caveavin.bo.vin.Region;
import fr.eni.ecole.caveavin.dal.vin.BouteilleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class TestRequetes {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    BouteilleRepository bouteilleRepository;

    Region paysDeLaLoire;
    Couleur blanc;
    List<Bouteille> bouteilles;

    @BeforeEach
    void initDB() {
        jeuDeDonneesBouteilles();
        jeuDeDonneesUtilisateur();
    }

    private void jeuDeDonneesBouteilles() {
        final Couleur rouge = Couleur
                .builder()
                .nom("Rouge")
                .build();

        blanc = Couleur
                .builder()
                .nom("Blanc")
                .build();

        final Couleur rose = Couleur
                .builder()
                .nom("Rosé")
                .build();

        entityManager.persist(rouge);
        entityManager.persist(blanc);
        entityManager.persist(rose);
        entityManager.flush();

        final Region grandEst = Region
                .builder()
                .nom("Grand Est")
                .build();

        paysDeLaLoire = Region
                .builder()
                .nom("Pays de la Loire")
                .build();

        final Region nouvelleAquitaine = Region
                .builder()
                .nom("Nouvelle-Aquitaine")
                .build();

        entityManager.persist(grandEst);
        entityManager.persist(paysDeLaLoire);
        entityManager.persist(nouvelleAquitaine);
        entityManager.flush();

        bouteilles = new ArrayList<>();
        bouteilles.add(Bouteille
                .builder()
                .nom("Blanc du DOMAINE ENI Ecole")
                .millesime("2022")
                .prix(BigDecimal.valueOf(23.95f))
                .quantite(1298)
                .region(paysDeLaLoire)
                .couleur(blanc)
                .build());
        bouteilles.add(Bouteille
                .builder()
                .nom("Rouge du DOMAINE ENI Ecole")
                .millesime("2018")
                .prix(BigDecimal.valueOf(11.45f))
                .quantite(987)
                .region(paysDeLaLoire)
                .couleur(rouge)
                .build());
        bouteilles.add(Bouteille
                .builder()
                .nom("Blanc du DOMAINE ENI Service")
                .millesime("2022")
                .prix(BigDecimal.valueOf(34))
                .petillant(true)
                .quantite(111)
                .region(grandEst)
                .couleur(blanc)
                .build());
        bouteilles.add(Bouteille
                .builder()
                .nom("Rouge du DOMAINE ENI Service")
                .millesime("2012")
                .prix(BigDecimal.valueOf(8.15f))
                .quantite(344)
                .region(paysDeLaLoire)
                .couleur(rouge)
                .build());
        bouteilles.add(Bouteille
                .builder()
                .nom("Rosé du DOMAINE ENI")
                .millesime("2020")
                .prix(BigDecimal.valueOf(33))
                .quantite(1987)
                .region(nouvelleAquitaine)
                .couleur(rose)
                .build());

        bouteilles.forEach(e -> {
            entityManager.persist(e);
            // Vérification de l'identifiant
            assertThat(e.getId()).isGreaterThan(0);
        });
        entityManager.flush();

    }

    private void jeuDeDonneesUtilisateur() {
        final List<Utilisateur> utilisateurs = new ArrayList<>();
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
            entityManager.persist(e);
        });
        entityManager.flush();
    }

    @Test
    void findByPseudoTest(){
        Utilisateur utilsiateur = utilisateurRepository.findByPseudo("georgelucas@email.fr");
        Assertions.assertNotNull(utilsiateur);
    }

    @Test
    void findByPseudoAndPasswordTest(){
        Utilisateur utilsiateur = utilisateurRepository.findByPseudoAndPassword("georgelucas@email.fr","Réalisateur&Producteur");
        Assertions.assertNotNull(utilsiateur);
    }

    @Test
    void findByRegionTest(){
        List<Bouteille> bouteilles = bouteilleRepository.findByRegion(paysDeLaLoire);
        Assertions.assertNotNull(bouteilles);
        Assertions.assertEquals(3,bouteilles.size());
    }

    @Test
    void findByCouleurTest(){
        List<Bouteille> bouteilles = bouteilleRepository.findByCouleur(blanc);
        Assertions.assertNotNull(bouteilles);
        Assertions.assertEquals(2,bouteilles.size());
    }
}
