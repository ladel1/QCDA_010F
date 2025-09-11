package fr.eni.ecole.demovehicule.repository.tableperclass;

import fr.eni.ecole.demovehicule.entity.tableperclass.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
