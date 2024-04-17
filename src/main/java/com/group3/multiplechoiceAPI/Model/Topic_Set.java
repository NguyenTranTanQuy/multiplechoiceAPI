package com.group3.multiplechoiceAPI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Topic_Set {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long topicSetID;

    private String topicSetName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    private Float duration;

    @ManyToOne
    @JoinColumn(name="topicID")
    private Topic topic;

    @OneToMany(mappedBy = "topicSet")
    private List<Question> questionList;

    @OneToMany(mappedBy = "topicSet")
    private List<Share> shareList;

    @OneToMany(mappedBy = "topicSet")
    private List<Assignment> assignmentList;
}
