package fr.eni.ecole.demo2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToOne(mappedBy="user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Profile profile;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch =  FetchType.EAGER)
    @JoinColumn(name="user_id")
    @Builder.Default
    private List<Post> posts = new ArrayList<>();

    public void setProfile(Profile profile){
        this.profile = profile;
        if(this.profile!=null){
            this.profile.setUser(this);
        }
    }
}
