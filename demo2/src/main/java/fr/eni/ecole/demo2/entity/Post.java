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
@Table(name="posts")
public class Post {// publication dans un réseau sociale
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String content;
}
