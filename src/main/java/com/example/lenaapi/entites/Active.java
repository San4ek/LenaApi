package com.example.lenaapi.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Active {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @OneToMany(mappedBy = "active", cascade = CascadeType.REMOVE)
    private List<Action> action;

    private boolean isWriteOff;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Type type;

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum Type {
        FURNITURE("Furniture"),
        ELECTRICAL("Electrical");

        private final String name;
    }
}
