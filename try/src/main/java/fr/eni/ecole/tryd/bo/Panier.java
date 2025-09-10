package fr.eni.ecole.tryd.bo;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "paniers")
@Entity
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "num_commande")
    private String numCommande;

    @Column(name = "prix_total", precision = 2)
    private float prixTotal;

    @Column(nullable = false)
    private boolean paye;

    @OneToMany(mappedBy = "panier", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<LignePanier> lignesPanier = new ArrayList<>();

    public void addLignePanier(LignePanier ligne) {
        lignesPanier.add(ligne);
        ligne.setPanier(this);
    }

    public void removeLignePanier(LignePanier ligne) {
        lignesPanier.remove(ligne);
        ligne.setPanier(null);
    }
}
