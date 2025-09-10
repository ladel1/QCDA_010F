package fr.eni.ecole.caveavin.dal.vin;

import fr.eni.ecole.caveavin.bo.vin.Bouteille;
import fr.eni.ecole.caveavin.bo.vin.Couleur;
import fr.eni.ecole.caveavin.bo.vin.Region;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
public class TestManyToOne {

//    @Autowired
//    private TestEntityManager entityManager;

    @Autowired
    BouteilleRepository bouteilleRepository;

    @Autowired
    CouleurRepository couleurRepository;

    @Autowired
    RegionRepository regionRepository;

    Couleur rouge;
    Couleur blanc;
    Couleur rose;

    Region grandEst;
    Region paysDeLaLoire;
    Region nouvelleAquitaine;

    @BeforeEach
    public void initDB() {
        rouge = Couleur
                .builder()
                .nom("Rouge")
                .build();

        blanc = Couleur
                .builder()
                .nom("Blanc")
                .build();

        rose = Couleur
                .builder()
                .nom("Rosé")
                .build();

        couleurRepository.save(rouge);
        couleurRepository.save(blanc);
        couleurRepository.save(rose);

        grandEst =
                Region
                        .builder()
                        .nom("Grand Est")
                        .build();

        paysDeLaLoire =
                Region
                        .builder()
                        .nom("Pays de la Loire")
                        .build();

        nouvelleAquitaine =
                Region
                        .builder()
                        .nom("Nouvelle Aquitaine")
                        .build();

        regionRepository.save(grandEst);
        regionRepository.save(paysDeLaLoire);
        regionRepository.save(nouvelleAquitaine);
    }

    @Test
    public void test_save(){

        Bouteille bouteille = Bouteille.builder()
                .nom("Blanc du DOMAINE ENI Ecole")
                .millesime("2022")
                .prix(BigDecimal.valueOf(23.95f))
                .quantite(1298)
                .region(paysDeLaLoire)
                .couleur(blanc)
                .build();

        bouteilleRepository.save(bouteille);

        Optional<Bouteille> savedBouteille = bouteilleRepository.findById(bouteille.getId());

        Assertions.assertTrue(savedBouteille.isPresent());
        Assertions.assertNotNull(savedBouteille.get().getRegion());
        Assertions.assertNotNull(savedBouteille.get().getCouleur());

        System.out.println(savedBouteille.get());
    }

    @Test
    public void test_save_bouteilles_regions_couleurs(){
        List<Bouteille> bouteilles = jeuDeDonnees();

        bouteilleRepository.saveAll(bouteilles);
        bouteilles.forEach(bouteille -> {
           Assertions.assertNotNull(bouteille.getId());
        });

    }

    @Test
    public void test_delete(){
        Bouteille bouteille = Bouteille.builder()
                .nom("Blanc du DOMAINE ENI Ecole")
                .millesime("2022")
                .prix(BigDecimal.valueOf(23.95f))
                .quantite(1298)
                .region(paysDeLaLoire)
                .couleur(blanc)
                .build();

        bouteilleRepository.save(bouteille);

        Optional<Bouteille> savedBouteille = bouteilleRepository.findById(bouteille.getId());
        Assertions.assertTrue(savedBouteille.isPresent());
        Assertions.assertNotNull(savedBouteille.get().getRegion());
        Assertions.assertNotNull(savedBouteille.get().getCouleur());
        System.out.println(savedBouteille.get());

        int bouteilleId= bouteille.getId();
        bouteilleRepository.delete(savedBouteille.get());
        Optional<Bouteille> deletedBouteille = bouteilleRepository.findById(bouteilleId);
        Assertions.assertTrue(deletedBouteille.isEmpty());

        Optional<Couleur> savedCouleur = couleurRepository.findById(bouteille.getCouleur().getId());
        Assertions.assertTrue(savedCouleur.isPresent());
        System.out.println(savedCouleur.get());

        Optional<Region> savedRegion = regionRepository.findById(bouteille.getRegion().getId());
        Assertions.assertTrue(savedRegion.isPresent());
        System.out.println(savedRegion.get());
    }


    private List<Bouteille> jeuDeDonnees() {
        List<Bouteille> bouteilles = new ArrayList<>();
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
        return bouteilles;
    }
}
