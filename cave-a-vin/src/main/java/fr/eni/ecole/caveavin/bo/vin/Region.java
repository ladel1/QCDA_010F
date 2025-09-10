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
@Table(name="CAV_REGION")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="REGION_ID")
    private Integer id;

    @Column(name="name")
    private String nom;
}