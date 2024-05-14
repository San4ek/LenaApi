package com.example.lenaapi.repositories;

import com.example.lenaapi.entites.Active;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActiveRepository extends JpaRepository<Active, Long> {

    List<Active> findByIsWriteOff(boolean isWriteOff);

    long countByTypeAndIsWriteOff(Active.Type type, boolean isWriteOff);

}
