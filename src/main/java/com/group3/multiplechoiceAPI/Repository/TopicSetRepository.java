package com.group3.multiplechoiceAPI.Repository;

import com.group3.multiplechoiceAPI.Model.Topic_Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicSetRepository extends JpaRepository<Topic_Set, Long> {
}
