package fr.eni.ecole.demovehicule.repository.joined;

import fr.eni.ecole.demovehicule.entity.joined.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Long> {
}
