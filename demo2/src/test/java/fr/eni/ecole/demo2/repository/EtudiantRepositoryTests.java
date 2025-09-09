package fr.eni.ecole.demo2.repository;

import fr.eni.ecole.demo2.entity.Etudiant;
import fr.eni.ecole.demo2.entity.IdEtudiant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class EtudiantRepositoryTests {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Test
    public void ajouterEtudiantTest(){
        String email = "gael@gmail.com";
        IdEtudiant idGael = IdEtudiant
                .builder()
                .email(email)
                .immatriculation("113500002025")
                .build();

        Etudiant gael = Etudiant
                .builder()
                .firstname("Gael")
                .lastname("Deschamps")
                .id(idGael)
                .build();

        etudiantRepository.save(gael);
        Etudiant savedStudent = etudiantRepository.findById(idGael).get();

        Assertions.assertNotNull(savedStudent);
        Assertions.assertEquals(savedStudent.getId().getEmail(),email);

    }
}
