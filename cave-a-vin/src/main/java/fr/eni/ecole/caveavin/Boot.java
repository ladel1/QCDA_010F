package fr.eni.ecole.caveavin;

import fr.eni.ecole.caveavin.bo.client.LignePanier;
import fr.eni.ecole.caveavin.bo.client.Panier;
import fr.eni.ecole.caveavin.dal.PanierRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Boot implements CommandLineRunner {
    private final PanierRepository panierRepository;

    @Override
    public void run(String... args) throws Exception {
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

        List<Panier> savedPaniers = panierRepository.findAll();

        System.out.println(savedPaniers);
    }
}
