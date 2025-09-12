package fr.eni.ecole.caveavin.dal.client;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import fr.eni.ecole.caveavin.bo.client.LignePanier;
import fr.eni.ecole.caveavin.bo.vin.Bouteille;
import fr.eni.ecole.caveavin.bo.vin.Couleur;
import fr.eni.ecole.caveavin.bo.vin.Region;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

//@SpringBootTest
@DataJpaTest
@ActiveProfiles("test")
public class TestManyToOneLignePanierBouteille {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    LignePanierRepository repository;


    private Bouteille b1;

    @BeforeEach
    public void initDB() {
        final Couleur blanc = Couleur
                .builder()
                .nom("Blanc")
                .build();

        entityManager.persist(blanc);

        final Region paysDeLaLoire = Region
                .builder()
                .nom("Pays de la Loire")
                .build();

        entityManager.persist(paysDeLaLoire);
        entityManager.flush();

        b1 = Bouteille
                .builder()
                .nom("DOMAINE ENI Ecole")
                .millesime("2022")
                .prix(BigDecimal.valueOf(23.95f))
                .quantite(1298)
                .region(paysDeLaLoire)
                .couleur(blanc)
                .build();
        entityManager.persist(b1);
        entityManager.flush();
    }

    @Test
    public void test_save() {
        int qte = 4;
        final LignePanier lp = LignePanier
                .builder()
                .qteCommande(qte)
                .prix(BigDecimal.valueOf(qte * b1.getPrix().doubleValue()))
                .build();

        // Association OneToMany
        lp.setBouteille(b1);

        // Appel du comportement
        final LignePanier lpDB = repository.save(lp);
        // Vérification de l'identifiant
        assertThat(lpDB.getId()).isGreaterThan(0);

        // Vérification de l'association
        assertThat(lpDB.getBouteille()).isNotNull();
        assertThat(lpDB.getBouteille().getId()).isEqualTo(b1.getId());
        assertThat(lpDB.getPrix()).isEqualTo(BigDecimal.valueOf(qte * b1.getPrix().doubleValue()));
        System.out.println(lpDB.toString());
    }

    @Test
    public void test_delete() {
        int qte = 4;
        final LignePanier lp = LignePanier
                .builder()
                .qteCommande(qte)
                .prix(BigDecimal.valueOf(qte * b1.getPrix().doubleValue()))
                .build();

        // Association OneToMany
        lp.setBouteille(b1);

        // Appel du comportement
        final LignePanier lpDB = entityManager.persist(lp);
        entityManager.flush();
        // Vérification de l'identifiant
        assertThat(lpDB.getId()).isGreaterThan(0);

        // Appel du comportement
        repository.delete(lpDB);

        // Vérification que l'entité a été supprimée
        final LignePanier lpDB2 = entityManager.find(LignePanier.class, lpDB.getId());
        assertNull(lpDB2);

        //Vérifier que la bouteille n'a pas été supprimée
        final Bouteille b = entityManager.find(Bouteille.class, b1.getId());
        assertNotNull(b);
    }
}
