package com.group3.multiplechoiceAPI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Topic_Set {
    private @Id String topicSetCode;
    private String topicSetName;
    private Date created;
    private Float duration;

    @ManyToOne
    @JoinColumn(name="topicCode")
    private Topic topic;

    @OneToMany(mappedBy = "topicSet")
    private List<Question> questionList;

    @OneToMany(mappedBy = "topicSet")
    private List<Share> shareList;

    @OneToMany(mappedBy = "topicSet")
    private List<Assignment> assignmentList;
}
