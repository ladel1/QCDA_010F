package fr.eni.ecole.demovehicule.entity.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="medecins")
public class Medecin extends Personne {
    private float tarif;
    private String specialite;
}
