package fr.eni.ecole.demovehicule.entity.joined;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"id"})

@Entity
@Table(name="documents")
@Inheritance(strategy = InheritanceType.JOINED)
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nom;
    @Column(name="date_parution")
    private Instant dateParution;
    @Column(name="nombre_de_page")
    private int nombrePage;
}
