package fr.eni.ecole.demovehicule.repository.joined;

import fr.eni.ecole.demovehicule.entity.joined.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal,Long>
{
}
