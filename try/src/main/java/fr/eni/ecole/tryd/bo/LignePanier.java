package fr.eni.ecole.tryd.bo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lignes_panier")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LignePanier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private int quantite;

    @Column(precision = 2, nullable = false)
    private float prix;

    @ManyToOne
    @JoinColumn(name = "panier_id")
    @ToString.Exclude
    private Panier panier;

}