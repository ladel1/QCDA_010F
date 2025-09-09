package fr.eni.ecole.demo2.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(of={"userId","postId"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class IdLike implements Serializable {
    private Long userId;
    private Long postId;
}
