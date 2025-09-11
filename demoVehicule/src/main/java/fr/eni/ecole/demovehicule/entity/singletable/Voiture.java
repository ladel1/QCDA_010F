package fr.eni.ecole.demovehicule.entity.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder

@Entity()
@DiscriminatorValue("Voiture")
public class Voiture extends Vehicule {
    private int nombreRoues;
}
