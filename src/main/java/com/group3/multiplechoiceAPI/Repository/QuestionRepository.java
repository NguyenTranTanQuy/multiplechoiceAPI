package com.group3.multiplechoiceAPI.Repository;

import com.group3.multiplechoiceAPI.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
