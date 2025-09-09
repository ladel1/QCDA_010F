package fr.eni.ecole.demolombok.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private String username;
    @ToString.Exclude
    private String password;
    private String email;
}
