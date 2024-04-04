package com.group3.multiplechoiceAPI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Question {
    private @Id String questionCode;
    private String questionContent;
    private String answer;

    @OneToMany(mappedBy = "question")
    private List<Selection> selectionList;

    @ManyToOne
    @JoinColumn(name="topicSetCode")
    private Topic_Set topicSet;

    @OneToMany(mappedBy = "question")
    private List<Detailed_Assignment> detailedAssignmentList;
}
