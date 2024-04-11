package com.group3.multiplechoiceAPI.Repository;

import com.group3.multiplechoiceAPI.Model.Assignment;
import com.group3.multiplechoiceAPI.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByUser(User user);
}
