package fr.eni.ecole.demovehicule.entity.joined;

import jakarta.persistence.Column;
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
@Table(name="livres")
@PrimaryKeyJoinColumn(name="livre_id")// pour renommer la clé primaire
public class Livre extends Document {
    private String isbn;
    private String auteur;
    @Column(name="maison_edition")
    private String maisonEdition;
}
