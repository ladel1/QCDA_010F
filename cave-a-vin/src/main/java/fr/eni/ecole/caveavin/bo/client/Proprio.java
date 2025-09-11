package fr.eni.ecole.caveavin.bo.client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
@Table(name="CAV_OWNER")
public class Proprio extends Utilisateur {
    @Column(name="CLIENT_NUMBER",length=14)
    private String siret;
}
