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
public class Assignment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id long assignmentID;
    private Date testDate;
    private Float duration;

    @ManyToOne
    @JoinColumn(name="username")
    private User user;

    @OneToMany(mappedBy = "assignment")
    private List<Detailed_Assignment> detailedAssignmentList;

    @ManyToOne
    @JoinColumn(name="topicSetID")
    private Topic_Set topicSet;
}
