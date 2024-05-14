package com.example.lenaapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ActiveForSendFullModel {

    private long id;

    private String name;

    private String auditoryNumber;

    private String worker;

    private String type;

    private List<ActionForSendModel> actions;
}
