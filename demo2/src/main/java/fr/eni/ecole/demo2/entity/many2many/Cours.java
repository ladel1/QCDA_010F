package fr.eni.ecole.demo2.entity.many2many;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of={"id","titre","filiere"})
@Builder

@Entity
@Table(name="cours")
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filiere;
    private String titre;
}
