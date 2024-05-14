package com.example.lenaapi.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name = "active_id")
    private Active active;

    @NonNull
    private Date dateTime;

    @NonNull
    @Enumerated(EnumType.STRING)
    private State state;

    @Getter
    @AllArgsConstructor(access = AccessLevel.PACKAGE)
    public enum State {
        ARRIVAL("Arrival"),
        MOVING("Moving"),
        INVENTORY("Inventory"),
        WRITE_OFF("Write off");

        private final String name;
    }
}
