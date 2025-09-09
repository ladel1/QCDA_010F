package fr.eni.ecole.demo2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of={"email","immatriculation"})
@Embeddable
public class IdEtudiant implements Serializable {
    @Column(name="EMAIL",unique = true,nullable = false)
    private String email;

    @Column(name="IMMAT",unique = true,nullable = false)
    private String immatriculation;
}
