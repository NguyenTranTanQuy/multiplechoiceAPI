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
    private @Id String assignmentCode;
    private Date testDate;
    private Float score;
    private int nb_completedSentences;
    private Float duration;

    @ManyToOne
    @JoinColumn(name="username")
    private User user;

    @OneToMany(mappedBy = "assignment")
    private List<Detailed_Assignment> detailedAssignmentList;
}
