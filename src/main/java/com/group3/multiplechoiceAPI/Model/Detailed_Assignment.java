package com.group3.multiplechoiceAPI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Detailed_Assignment {
    @EmbeddedId
    private DetailedAssignmentKey id;

    @ManyToOne
    @MapsId("assignmentCode")
    @JoinColumn(name="assignmentCode")
    private Assignment assignment;

    @ManyToOne
    @MapsId("questionCode")
    @JoinColumn(name="questionCode")
    private Question question;

    private String selectedAnswer;
}
