package fr.eni.ecole.demo2.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User { // utilisateur
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String username;

    @OneToOne(mappedBy="user")
    private Profile profile;

    public void setProfile(Profile profile){
        this.profile = profile;
        if(this.profile!=null){
            this.profile.setUser(this);
        }
    }
}
