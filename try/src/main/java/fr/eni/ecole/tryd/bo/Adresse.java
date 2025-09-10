package fr.eni.ecole.tryd.bo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "adresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String rue;

    @Column(nullable = false)
    private String codePostal;

    @Column(nullable = false)
    private String ville;

}