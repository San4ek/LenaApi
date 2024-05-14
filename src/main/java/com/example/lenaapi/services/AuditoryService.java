package com.example.lenaapi.services;

import com.example.lenaapi.entites.Auditory;
import com.example.lenaapi.repositories.AuditoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuditoryService {

    private final AuditoryRepository auditoryRepository;

    public List<Auditory> getAll() {
        return auditoryRepository.findAllNumbers();
    }

    public Auditory getByNumber(String number) {
        return auditoryRepository.findById(number).get();
    }
}
