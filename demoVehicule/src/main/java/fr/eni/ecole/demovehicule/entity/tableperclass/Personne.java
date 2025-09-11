package fr.eni.ecole.demovehicule.entity.tableperclass;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"id","nom","prenom"})

@Entity
@Table(name="personnes")
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String nom;
    private String prenom;
    @Column(length=13)
    private String nss;
    private int age;
}
