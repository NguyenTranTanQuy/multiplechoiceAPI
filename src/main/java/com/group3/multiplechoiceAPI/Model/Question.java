package com.group3.multiplechoiceAPI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Question {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long questionID;
    private String questionContent;
    private String answer;

    @OneToMany(mappedBy = "question")
    private List<Selection> selectionList;

    @ManyToOne
    @JoinColumn(name="topicSetID")
    private Topic_Set topicSet;

    @OneToMany(mappedBy = "question")
    private List<Detailed_Assignment> detailedAssignmentList;
}
