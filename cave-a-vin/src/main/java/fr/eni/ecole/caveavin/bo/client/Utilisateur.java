package fr.eni.ecole.caveavin.bo.client;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"pseudo"})
@SuperBuilder

@Entity
@Table(name="CAV_USER")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
    @Id
    @Column(name="LOGIN", unique=true, nullable=false)
    private String pseudo;

    @ToString.Exclude
    @Column(name="PASSWORD")
    private String password;

    @Column(name="LAST_NAME")
    private String nom;

    @Column(name="FIRST_NAME")
    private String prenom;
}
