package fr.eni.ecole.demovehicule;

import fr.eni.ecole.demovehicule.entity.singletable.Bateau;
import fr.eni.ecole.demovehicule.entity.singletable.Vehicule;
import fr.eni.ecole.demovehicule.entity.singletable.Voiture;
import fr.eni.ecole.demovehicule.repository.singletable.BateauRepository;
import fr.eni.ecole.demovehicule.repository.singletable.VehiculeRepository;
import fr.eni.ecole.demovehicule.repository.singletable.VoitureRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class SingleTableTests {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private VoitureRepository voitureRepository;
    @Autowired
    private BateauRepository bateauRepository;

    @Test
    void ajouterVehiculeTest(){
        Vehicule vehicule = Vehicule.builder()
                .immatriculation("35465s4f65sd4f")
                .marque("test")
                .modele("test")
                .couleur("test")
                .build();

        vehiculeRepository.save(vehicule);
        Assertions.assertNotNull(vehicule.getId());
        System.out.println(vehicule);
    }
    @Test
    void ajouterVoitureTest(){
        Voiture voiture = Voiture.builder()
                .immatriculation("CV-954-FD")
                .marque("Bugatti")
                .modele("Chiron")
                .couleur("Noir")
                .nombreRoues(4)
                .build();

        voitureRepository.save(voiture);
        Assertions.assertNotNull(voiture.getId());
        System.out.println(voiture);
    }
    @Test
    void ajouterBateauTest(){
        Bateau bateau = Bateau.builder()
                .immatriculation("sdifhskdjh")
                .marque("Quicksilver")
                .modele("Pilothouse")
                .couleur("Blanc")
                .nom("Cathrina")
                .pavillonBateau("France")
                .build();


        bateauRepository.save(bateau);
        Assertions.assertNotNull(bateau.getId());
        System.out.println(bateau);
    }

}
