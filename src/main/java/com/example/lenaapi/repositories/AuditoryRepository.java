package com.example.lenaapi.repositories;

import com.example.lenaapi.entites.Auditory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditoryRepository extends JpaRepository<Auditory, String> {

    @Query("SELECT Auditory AS a FROM Auditory")
    List<Auditory> findAllNumbers();

}
