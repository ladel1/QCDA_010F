package fr.eni.ecole.demo2.entity.many2many;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of={"id","immat"})
@Builder

@Entity
@Table(name="formateurs")
public class Formateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String immat;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="formateurs_cours",
            joinColumns = { @JoinColumn(name="formateur_id") },// la clé de formateur (cette classe)
            inverseJoinColumns = {@JoinColumn(name="cours_id")}// la clé de l'autre classe
    )
    @Builder.Default
    private Set<Cours>  courses =  new HashSet<Cours>();

}
