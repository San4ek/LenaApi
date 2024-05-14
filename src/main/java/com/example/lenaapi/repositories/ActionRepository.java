package com.example.lenaapi.repositories;

import com.example.lenaapi.entites.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {

    @Query("SELECT Action " +
            "FROM Action AS a " +
            "WHERE a.active.id=:activeId")
    List<Action> findAll(Long activeId);

}
