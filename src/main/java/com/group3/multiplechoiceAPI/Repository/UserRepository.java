package com.group3.multiplechoiceAPI.Repository;

import com.group3.multiplechoiceAPI.DTO.Tested_Assignment;
import com.group3.multiplechoiceAPI.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.username = :username")
    Optional<User> findUserByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM User WHERE username = :username")
    void deleteByUsername(String username);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.password = :password WHERE u.username = :username")
    void resetPassword(String username, String password);

    @Procedure(name="getTestByUsername")
    List<Object[]> getTestByUsername(String username);
}
