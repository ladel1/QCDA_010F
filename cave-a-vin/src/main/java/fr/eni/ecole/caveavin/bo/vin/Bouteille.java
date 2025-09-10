package fr.eni.ecole.caveavin.bo.vin;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder

@Entity
@Table(name="CAV_BOTTLE")
public class Bouteille {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BOTTLE_ID")
    private Integer id;

    @Column(name="name",length = 250,unique = true,nullable = false)
    private String nom;

    @Column(name="SPARKLING")
    private boolean petillant;

    @Column(name="VINTAGE",length=100)
    private String millesime;

    @Column(name="QUANTITY")
    private int quantite;

    @Column(name="PRICE",scale = 2)
    private BigDecimal prix;

    @ManyToOne
    @JoinColumn(name="REGION_ID")
    @EqualsAndHashCode.Exclude
    private Region region;

    @ManyToOne
    @JoinColumn(name="COLOR_ID")
    @EqualsAndHashCode.Exclude
    private Couleur couleur;
}
