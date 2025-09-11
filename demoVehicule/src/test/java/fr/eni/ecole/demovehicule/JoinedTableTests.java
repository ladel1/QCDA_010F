package fr.eni.ecole.demovehicule;

import fr.eni.ecole.demovehicule.entity.joined.Document;
import fr.eni.ecole.demovehicule.entity.joined.Journal;
import fr.eni.ecole.demovehicule.entity.joined.Livre;
import fr.eni.ecole.demovehicule.repository.joined.DocumentRepository;
import fr.eni.ecole.demovehicule.repository.joined.JournalRepository;
import fr.eni.ecole.demovehicule.repository.joined.LivreRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;

@SpringBootTest
@ActiveProfiles("test")
public class JoinedTableTests {
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private LivreRepository livreRepository;
    @Autowired
    private JournalRepository journalRepository;

    @Test
    void ajouterUnDocument(){
        // Arrange
        Document document = Document.builder()
                .nom("Cours Python")
                .dateParution(Instant.now())
                .nombrePage(250)
                .build();
        //Act
        documentRepository.save(document);
        // Assert
        Assertions.assertNotNull(document.getId());
        // Log
        System.out.println(document);
    }

    @Test
    void ajouterUnLivre(){
        // Arrange
        Livre livre = Livre.builder()
                .nom("The worlf of wall street")
                .auteur("Jordan Belfort")
                .maisonEdition("akvkava")
                .isbn("lablab")
                .dateParution(Instant.now())
                .nombrePage(250)
                .build();
        //Act
        livreRepository.save(livre);
        // Assert
        Assertions.assertNotNull(livre.getId());
        // Log
        System.out.println(livre);
    }

    @Test
    void ajouterUnJournal(){
        // Arrange
        Journal journal = Journal.builder()
                .nom("L'Équipe")
                .periodicite("Quotidienne")
                .dateParution(Instant.now())
                .nombrePage(250)
                .build();
        //Act
        journalRepository.save(journal);
        // Assert
        Assertions.assertNotNull(journal.getId());
        // Log
        System.out.println(journal);
    }

}
