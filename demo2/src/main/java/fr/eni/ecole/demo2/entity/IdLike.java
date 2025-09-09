package fr.eni.ecole.demo2.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(of={"user","post"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class IdLike implements Serializable {
    private Long user;
    private Long post;
}
