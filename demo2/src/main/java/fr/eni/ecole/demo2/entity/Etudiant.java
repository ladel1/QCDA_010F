package fr.eni.ecole.demo2.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="etudiants")
public class Etudiant {
    @EmbeddedId
    private IdEtudiant id;
    private String lastname;
    private String firstname;
}
