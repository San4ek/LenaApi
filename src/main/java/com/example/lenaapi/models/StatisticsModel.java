package com.example.lenaapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsModel {

    private long writeOffValue;

    private long inUsingValue;

    private String type;

}
