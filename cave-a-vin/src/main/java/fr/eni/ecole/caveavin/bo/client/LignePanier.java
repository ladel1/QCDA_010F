package fr.eni.ecole.caveavin.bo.client;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder
@Entity
@Table(name="CAV_LINE")
public class LignePanier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LINE_ID")
    private Integer id;

    @Column(name="QUANTITY")
    private int qteCommande;

    @Column(name="PRICE",precision=5,scale=2)
    private BigDecimal prix;// BigDecimal pour la précision (nombre de  chiffre total) et scale (nombre de chiffre apres la virgule)
}
