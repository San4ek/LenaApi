package com.example.lenaapi.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;
    private String patronymic;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "worker", cascade = CascadeType.REFRESH)
    private List<Active> active;

    @ManyToOne
    @JoinColumn(name = "auditory_id")
    private Auditory auditory;
}
