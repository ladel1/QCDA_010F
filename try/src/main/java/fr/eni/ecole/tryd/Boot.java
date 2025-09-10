package fr.eni.ecole.tryd;

import fr.eni.ecole.tryd.bo.LignePanier;
import fr.eni.ecole.tryd.bo.Panier;
import fr.eni.ecole.tryd.repository.PanierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Boot implements ApplicationRunner
{

    private final PanierRepository panierRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception
	{
        LignePanier lp = LignePanier.builder()
                .prix(12.32f)
                .quantite(12)
                .build();
        Panier panier = Panier.builder()
                .paye(true)
                .prixTotal(16f)
                .numCommande("fdsfsdfdsd")
                .build();
        panier.addLignePanier(lp);

        panierRepository.save(panier);

        System.out.println("panier "+panier);

    }
}
