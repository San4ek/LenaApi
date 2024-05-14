package com.example.lenaapi.services;

import com.example.lenaapi.entites.Action;
import com.example.lenaapi.entites.Active;
import com.example.lenaapi.models.ActionForSaveModel;
import com.example.lenaapi.models.ActionForSendModel;
import com.example.lenaapi.repositories.ActionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActionService {

    private final ActionRepository actionRepository;
    private final ActiveService activeService;

    public long save(ActionForSaveModel actionForSaveModel) {

        Active active =activeService.findActive(actionForSaveModel.getActiveId());

        if (List.of(Action.State.values()).get(actionForSaveModel.getState())== Action.State.WRITE_OFF) {
            active.setWriteOff(true);
        }

        return actionRepository.save(new Action(active, actionForSaveModel.getDateTime(), List.of(Action.State.values()).get(actionForSaveModel.getState()))).getId();
    }
}
