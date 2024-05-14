package com.example.lenaapi.services;

import com.example.lenaapi.entites.Active;
import com.example.lenaapi.entites.Worker;
import com.example.lenaapi.models.ActionForSendModel;
import com.example.lenaapi.models.ActiveForSaveModel;
import com.example.lenaapi.models.ActiveForSendSmallModel;
import com.example.lenaapi.models.ActiveForSendFullModel;
import com.example.lenaapi.repositories.ActiveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActiveService {

    private final ActiveRepository activeRepository;
    private final WorkerService workerService;

    public ActiveForSendFullModel findById(long id) {
        Active active = activeRepository.findById(id).get();

        String worker= active.getWorker().getSurname() + " " +
                active.getWorker().getName() + " " +
                active.getWorker().getPatronymic();

        List<ActionForSendModel> actives= active.getAction().stream().map(val -> new ActionForSendModel(val.getDateTime(),val.getState().getName())).toList();

        return new ActiveForSendFullModel(active.getId(),
                active.getName(),
                active.getWorker().getAuditory().getNumber(),
                worker,
                active.getType().getName(),
                actives);
    }

    public Active findActive(long id) {
        return activeRepository.findById(id).get();
    }

    public List<ActiveForSendSmallModel> findAll() {
        return  activeRepository.findByIsWriteOff(false).stream().map(val -> new ActiveForSendSmallModel(val.getId(),val.getName())).toList();
    }

    public long getCount(Active.Type type, boolean isWriteOff){
        return activeRepository.countByTypeAndIsWriteOff(type, isWriteOff);
    }


    public Active save(ActiveForSaveModel activeForSaveModel) {
        Worker worker=workerService.getById(activeForSaveModel.getWorker());
        System.out.println(worker);
        Active.Type type= List.of(Active.Type.values()).get(activeForSaveModel.getType());
        System.out.println(type);

        return activeRepository.save(new Active(activeForSaveModel.getName(), worker, type));
    }
}
