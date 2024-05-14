package com.example.lenaapi.repositories;

import com.example.lenaapi.entites.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByLogin(String login);

    Optional<User> findByLoginAndPassword(String login, String password);

    Optional<User> findByLogin(String login);

    List<User> findAllByRole(User.Role role);

    @Modifying
    @Transactional
    @Query("UPDATE User AS u " +
            "SET u.isBlocked=:isBlocked WHERE u.login=:login")
    int updateBlockStatus(@Param("login") String login, @Param("isBlocked") boolean isBlocked);
}
