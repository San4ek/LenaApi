package com.example.lenaapi.entites;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(unique = true)
    private String login;

    @NonNull
    private String password;

    private boolean isBlocked;

    @Enumerated(EnumType.STRING)
    private Role role=Role.USER;

    public enum Role {
        USER,
        ADMIN
    }
}
