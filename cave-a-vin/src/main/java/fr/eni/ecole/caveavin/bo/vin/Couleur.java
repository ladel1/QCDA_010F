package fr.eni.ecole.caveavin.bo.vin;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder

@Entity
@Table(name="CAV_COLOR")
public class Couleur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COLOR_ID")
    private Integer id;

    @Column(name="name")
    private String nom;
}
