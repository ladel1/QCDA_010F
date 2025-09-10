package fr.eni.ecole.caveavin.dal;

import fr.eni.ecole.caveavin.bo.client.LignePanier;
import fr.eni.ecole.caveavin.bo.client.Panier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class PanierRepositoryTests {
    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private LignePanierRepository lignePanierRepository;

    @Test
    public void test_save_nouvelleLigne_nouveauPanier(){

        LignePanier l= LignePanier.builder()
                .prix(BigDecimal.valueOf(123.12556))
                .qteCommande(12)
                .build();
        Panier p= Panier.builder()
                .numCommande("000001")
                .paye(true)
                .prixTotal(BigDecimal.valueOf(223.1222))
                .build();
        p.getLignesPanier().add(l);

        panierRepository.save(p);
        System.out.println("Panier: "+p);
        Assertions.assertNotNull(l.getId());
        Assertions.assertNotNull(p.getId());

    }

    @Test
    public void test_save_nouvelleLigne_Panier(){
        LignePanier l= LignePanier.builder()
                .prix(BigDecimal.valueOf(123.12556))
                .qteCommande(12)
                .build();
        Panier p= Panier.builder()
                .numCommande("000001")
                .paye(true)
                .prixTotal(BigDecimal.valueOf(223.1222))
                .build();
        p.getLignesPanier().add(l);

        panierRepository.save(p);
        LignePanier l2= LignePanier.builder()
                .prix(BigDecimal.valueOf(2.65))
                .qteCommande(5)
                .build();
        p.getLignesPanier().add(l2);
        panierRepository.save(p);

        System.out.println("Panier: "+p);
        Assertions.assertNotNull(l.getId());
        Assertions.assertEquals(2,p.getLignesPanier().size());
    }

    @Test
    public void test_delete(){
        LignePanier l= LignePanier.builder()
                .prix(BigDecimal.valueOf(123.12556))
                .qteCommande(12)
                .build();
        Panier p= Panier.builder()
                .numCommande("000001")
                .paye(true)
                .prixTotal(BigDecimal.valueOf(223.1222))
                .build();
        p.getLignesPanier().add(l);

        panierRepository.save(p);
        int panierId = p.getId();
        panierRepository.delete(p);

        Assertions.assertFalse(panierRepository.findById(panierId).isPresent());
    }

    @Test
    public void test_orphanRemoval(){
        LignePanier l= LignePanier.builder()
                .prix(BigDecimal.valueOf(123.12556))
                .qteCommande(12)
                .build();
        Panier p= Panier.builder()
                .numCommande("000001")
                .paye(true)
                .prixTotal(BigDecimal.valueOf(223.1222))
                .build();
        p.getLignesPanier().add(l);

        panierRepository.save(p);

        int lignePanierId = l.getId();
        p.getLignesPanier().remove(l);
        panierRepository.save(p);


        Assertions.assertFalse(lignePanierRepository.findById(lignePanierId).isPresent());
    }


}
