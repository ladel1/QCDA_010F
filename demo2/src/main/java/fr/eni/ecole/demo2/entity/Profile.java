package fr.eni.ecole.demo2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.nio.MappedByteBuffer;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String firstname;
    @Column(length = 30)
    private String lastname;
    private int age;

    @ToString.Exclude
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="user_id",unique=true,nullable=false)
    private User user;
}
