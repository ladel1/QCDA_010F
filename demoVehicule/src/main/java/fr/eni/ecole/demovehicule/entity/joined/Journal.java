package fr.eni.ecole.demovehicule.entity.joined;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@ToString(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="journaux")
//@PrimaryKeyJoinColumn(name="livre_id")// pour renommer la clé primaire
public class Journal extends Document {
    private String periodicite;
}
