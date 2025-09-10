package fr.eni.ecole.caveavin.bo.client;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder
@Entity
@Table(name="CAV_SHOPPING_CART")
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SHOPPING_CART_ID")
    private Integer id;

    @Column(name="ORDER_NUMBER")
    private String numCommande;

    @Column(name="TOTAL_PRICE",scale=2)
    private BigDecimal prixTotal;

    @Column(name="PAID")
    private boolean paye;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch=FetchType.EAGER)
    @JoinColumn(name="SHOPPING_CART_ID")
    @Builder.Default
    private List<LignePanier> lignesPanier = new ArrayList<LignePanier>();
}
