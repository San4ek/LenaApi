package com.example.lenaapi.services;

import com.example.lenaapi.entites.Action;
import com.example.lenaapi.models.ActiveStateModel;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ActionStateService {

    public List<ActiveStateModel> getAll() {
        return Arrays.stream(Action.State.values()).map(val -> new ActiveStateModel(val.ordinal(), val.getName())).toList();
    }

}
