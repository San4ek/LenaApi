package com.example.lenaapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ActionForSendModel {

    private Date dateTime;

    private String state;
}
