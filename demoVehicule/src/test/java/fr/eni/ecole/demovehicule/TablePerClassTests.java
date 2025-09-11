package fr.eni.ecole.demovehicule;

import fr.eni.ecole.demovehicule.entity.tableperclass.Medecin;
import fr.eni.ecole.demovehicule.entity.tableperclass.Patient;
import fr.eni.ecole.demovehicule.entity.tableperclass.Personne;
import fr.eni.ecole.demovehicule.repository.tableperclass.MedecinRepository;
import fr.eni.ecole.demovehicule.repository.tableperclass.PatientRepository;
import fr.eni.ecole.demovehicule.repository.tableperclass.PersonneRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class TablePerClassTests {

    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Test
    void ajouterPersonneTest(){

        Personne hugo = Personne.builder()
                .prenom("Hugo")
                .nom("Dupont")
                .age(12)
                .nss("3211654877")
                .build();

        personneRepository.save(hugo);
        Assertions.assertNotNull(hugo.getId());
        System.out.println(hugo);

    }
    @Test
    void ajouterMedecinTest(){

        Medecin cassandra = Medecin.builder()
                .prenom("Cassandra")
                .nom("Maisel")
                .age(35)
                .nss("5467844342")
                .specialite("Cardiologue")
                .tarif(30)
                .build();

        medecinRepository.save(cassandra);
        Assertions.assertNotNull(cassandra.getId());
        System.out.println(cassandra);

    }

    @Test
    void ajouterPatientTest(){

        Patient pierre = Patient.builder()
                .prenom("Pierre")
                .nom("Chevalier")
                .age(50)
                .nss("3211654877")
                .diagnostique("blabalbalab")
                .description("blabalabla")
                .build();

        patientRepository.save(pierre);
        Assertions.assertNotNull(pierre.getId());
        System.out.println(pierre);

    }
}
