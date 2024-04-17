package com.group3.multiplechoiceAPI.Repository;

import com.group3.multiplechoiceAPI.Model.DetailedAssignmentKey;
import com.group3.multiplechoiceAPI.Model.Detailed_Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailedAssignmentRepository extends JpaRepository<Detailed_Assignment, DetailedAssignmentKey> {
}
