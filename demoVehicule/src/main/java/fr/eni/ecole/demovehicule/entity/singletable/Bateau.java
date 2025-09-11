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
@DiscriminatorValue("Bateau")
public class Bateau extends Vehicule {
    private String nom;
    private String pavillonBateau;
}
