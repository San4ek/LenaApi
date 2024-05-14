package com.example.lenaapi.services;

import com.example.lenaapi.entites.Worker;
import com.example.lenaapi.models.WorkerForSendModel;
import com.example.lenaapi.repositories.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;

    public List<WorkerForSendModel> getAll() {
        return workerRepository.findAll().stream().map(val -> new WorkerForSendModel(val.getId(),
                val.getSurname()+" "+val.getName()+" "+val.getPatronymic())).toList();
    }

    public Worker getById(long workerId) {
        return workerRepository.findById(workerId).get();
    }
}
