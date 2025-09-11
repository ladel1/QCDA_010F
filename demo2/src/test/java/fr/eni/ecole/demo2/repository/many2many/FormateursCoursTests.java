package fr.eni.ecole.demo2.repository.many2many;

import fr.eni.ecole.demo2.entity.many2many.Cours;
import fr.eni.ecole.demo2.entity.many2many.Formateur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
public class FormateursCoursTests {

    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private FormateurRepository formateurRepository;

    @Test
    void ajouterFormateurCoursTest(){
        Cours springBoot = Cours.builder()
                .titre("Spring Boot")
                .filiere("Dev")
                .build();

        Cours python = Cours.builder()
                .titre("Python")
                .filiere("DevOps")
                .build();

        Cours react = Cours.builder()
                .titre("React")
                .filiere("Dev")
                .build();

        coursRepository.saveAll(List.of(springBoot, python, react));

        long coursCount = coursRepository.count();
        Assertions.assertEquals(3,coursCount);

        Formateur adel = Formateur.builder()
                .prenom("Adel")
                .nom("Latibi")
                .immat("02154879663")
                .build();

        adel.getCourses().add(springBoot);
        adel.getCourses().add(python);

        formateurRepository.save(adel);
        Assertions.assertNotNull(adel.getId());
        System.out.println(adel);
    }

    @Test
    void supprimerCoursTest(){
        Cours springBoot = Cours.builder()
                .titre("Spring Boot")
                .filiere("Dev")
                .build();

        Cours python = Cours.builder()
                .titre("Python")
                .filiere("DevOps")
                .build();

        Cours react = Cours.builder()
                .titre("React")
                .filiere("Dev")
                .build();

        coursRepository.saveAll(List.of(springBoot, python, react));

        long coursCount = coursRepository.count();
        Assertions.assertEquals(3,coursCount);

        Formateur adel = Formateur.builder()
                .prenom("Adel")
                .nom("Latibi")
                .immat("02154879663")
                .build();

        adel.getCourses().add(springBoot);
        adel.getCourses().add(python);

        formateurRepository.save(adel);

        adel.getCourses().remove(springBoot);
        formateurRepository.save(adel);


        Optional<Cours> savedCoursSpringBoot = coursRepository.findById(springBoot.getId());
        Assertions.assertTrue(savedCoursSpringBoot.isPresent());

        Optional<Formateur> savedFormateurAdel = formateurRepository.findById(adel.getId());
        Assertions.assertTrue(savedFormateurAdel.isPresent());
        Assertions.assertFalse(savedFormateurAdel.get().getCourses().contains(springBoot));
        System.out.println(savedFormateurAdel);

    }

    void supprimerFormateurTest(){
        Cours springBoot = Cours.builder()
                .titre("Spring Boot")
                .filiere("Dev")
                .build();

        Cours python = Cours.builder()
                .titre("Python")
                .filiere("DevOps")
                .build();

        Cours react = Cours.builder()
                .titre("React")
                .filiere("Dev")
                .build();

        coursRepository.saveAll(List.of(springBoot, python, react));

        Formateur adel = Formateur.builder()
                .prenom("Adel")
                .nom("Latibi")
                .immat("02154879663")
                .build();

        adel.getCourses().add(springBoot);
        adel.getCourses().add(python);

        formateurRepository.save(adel);
        long formtauerId = adel.getId();
        formateurRepository.delete(adel);
        Optional<Formateur> savedFormateurAdel = formateurRepository.findById(formtauerId);
        Assertions.assertFalse(savedFormateurAdel.isPresent());

        long coursCount = coursRepository.count();
        Assertions.assertEquals(3,coursCount);   

    }

}
