package fr.eni.ecole.caveavin.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"pseudo"})
@Builder
@Entity
@Table(name="CAV_CLIENT")
public class Client {
    @Id
    @Column(name="LOGIN", unique=true, nullable=false)
    private String pseudo;

    @ToString.Exclude
    @Column(name="PASSWORD")
    private String password;

    @Column(name="LAST_NAME")
    private String nom;

    @Column(name="FIRST_NAME")
    private String prenom;
}
