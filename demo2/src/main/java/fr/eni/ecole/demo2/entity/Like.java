package fr.eni.ecole.demo2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="likes")
@IdClass(IdLike.class)
public class Like {
    @Id
    private Long user;

    @Id
    private Long post;
    private Instant createdAt;
}
