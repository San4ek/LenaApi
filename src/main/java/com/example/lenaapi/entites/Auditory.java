package com.example.lenaapi.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Auditory {

    @Id
    private String number;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "auditory", cascade = CascadeType.REFRESH)
    private List<Worker> worker;
}
