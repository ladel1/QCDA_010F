package fr.eni.ecole.demo2.entity;

import jakarta.persistence.*;
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
    @Column(name="user_id")
    private Long userId;

    @Id
    @Column(name="post_id")
    private Long postId;
    private Instant createdAt;
}
