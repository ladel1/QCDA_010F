package fr.eni.ecole.caveavin.dal.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import fr.eni.ecole.caveavin.bo.client.Client;
import fr.eni.ecole.caveavin.bo.client.LignePanier;
import fr.eni.ecole.caveavin.bo.client.Panier;
import fr.eni.ecole.caveavin.bo.vin.Bouteille;
import fr.eni.ecole.caveavin.bo.vin.Couleur;
import fr.eni.ecole.caveavin.bo.vin.Region;
import fr.eni.ecole.caveavin.dal.vin.BouteilleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
public class TestManyToOnePanierClient {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    PanierRepository panierRepository;

    @Autowired
    BouteilleRepository bouteilleRepository;

    @Autowired
    ClientRepository clientRepository;

    @BeforeEach
    public void initDB() {
        final List<Couleur> couleurs = new ArrayList<>();
        couleurs.add(Couleur
                .builder()
                .nom("Blanc")
                .build());
        couleurs.add(Couleur
                .builder()
                .nom("Rouge")
                .build());

        couleurs.forEach(item -> {
            entityManager.persist(item);
            assertThat(item.getId()).isGreaterThan(0);
        });
        entityManager.flush();

        final List<Region> regions = new ArrayList<>();
        regions.add(Region
                .builder()
                .nom("Pays de la Loire")
                .build());

        regions.add(Region
                .builder()
                .nom("Grand Est")
                .build());

        regions.forEach(item -> {
            entityManager.persist(item);
            assertThat(item.getId()).isGreaterThan(0);
        });
        entityManager.flush();

        final List<Bouteille> bouteilles = new ArrayList<>();
        bouteilles.add(Bouteille
                .builder()
                .nom("DOMAINE ENI Ecole")
                .millesime("2022")
                .prix(BigDecimal.valueOf(11.45f))
                .quantite(1298)
                .region(regions.get(0))
                .couleur(couleurs.get(0))
                .build());

        bouteilles.add(Bouteille
                .builder()
                .nom("DOMAINE ENI Service")
                .millesime("2015")
                .prix(BigDecimal.valueOf(23.95f))
                .quantite(2998)
                .region(regions.get(1))
                .couleur(couleurs.get(1))
                .build());

        bouteilles.forEach(item -> {
            entityManager.persist(item);
            assertThat(item.getId()).isGreaterThan(0);
        });
        entityManager.flush();
    }

    @Test
    void test_save_1panier(){
        Client client = Client.builder()
                .nom("Jhon")
                .prenom("Jhon")
                .pseudo("Jhon")
                .password("Jhon")
                .build();
        List<Panier> paniers = jeuDeDonnees();
        Panier panier = paniers.get(0);
        panier.setClient(client);
        Panier savedPanier = panierRepository.save(panier);
        assertThat(panier.getId()).isGreaterThan(0);
        assertThat(panier.getId()).isNotNull();
        System.out.println(panier);
    }

    @Test
    void test_save_paniers_unClient(){
        Client client = Client.builder()
                .nom("Jhon")
                .prenom("Jhon")
                .pseudo("Jhon")
                .password("Jhon")
                .build();
        List<Panier> paniers = jeuDeDonnees();
        paniers.forEach(panier -> {panier.setClient(client);});
        List<Panier> savedPaniers = panierRepository.saveAll(paniers);
        savedPaniers.forEach(panier -> {
            assertThat(panier.getId()).isGreaterThan(0);
            assertThat(panier.getId()).isNotNull();
        });
        System.out.println(savedPaniers);
    }

    @Test
    void test_delete(){
        Client client = Client.builder()
                .nom("Jhon")
                .prenom("Jhon")
                .pseudo("Jhon")
                .password("Jhon")
                .build();
        List<Panier> paniers = jeuDeDonnees();
        Panier panier = paniers.get(0);
        panier.setClient(client);
        Panier savedPanier = panierRepository.save(panier);
        int panierId = savedPanier.getId();
        assertThat(panier.getId()).isGreaterThan(0);
        assertThat(panier.getId()).isNotNull();
        System.out.println(panier);

        // détacher le client de panier
        savedPanier.setClient(null);
        panierRepository.save(savedPanier);

        // supprimer le client
        Client clientReq = clientRepository.findByPseudo("Jhon");
        clientRepository.delete(clientReq);
        clientRepository.flush();

        Client clientReq2 = clientRepository.findByPseudo("Jhon");
        assertThat(clientReq2).isNull();

        Optional<Panier> panierReq = panierRepository.findById(panierId);
        assertThat(panierReq).isPresent();
    }


    private List<Panier> jeuDeDonnees() {
        final List<Bouteille> bouteilles = bouteilleRepository.findAll();
        assertThat(bouteilles).isNotNull();
        assertThat(bouteilles).isNotEmpty();
        assertThat(bouteilles.size()).isEqualTo(2);

        final List<Panier> paniers = new ArrayList<>();

        final Panier p1 = new Panier();
        int qte1 = 3;
        final Bouteille b1 = bouteilles.get(0);
        final LignePanier lp1 = LignePanier
                .builder()
                .bouteille(b1)
                .qteCommande(qte1)
                .prix(BigDecimal.valueOf(qte1 * b1.getPrix().doubleValue()))
                .build();
        p1.getLignesPanier().add(lp1);
        p1.setPrixTotal(lp1.getPrix());
        paniers.add(p1);

        final Panier p2 = new Panier();
        int qte2 = 10;
        final Bouteille b2 = bouteilles.get(1);
        final LignePanier lp2 = LignePanier
                .builder()
                .bouteille(b2)
                .qteCommande(qte2)
                .prix(BigDecimal.valueOf(qte2 * b2.getPrix().doubleValue()))
                .build();
        p2.getLignesPanier().add(lp2);
        p2.setPrixTotal(lp2.getPrix());
        paniers.add(p2);

        return paniers;
    }
}
