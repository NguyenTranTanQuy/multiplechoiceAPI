package com.group3.multiplechoiceAPI.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="topic")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Topic {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long topicID;
    private @NonNull String topicName;

    @ManyToOne
    @JoinColumn(name="username")
    private User user;

    @OneToMany(mappedBy = "topic")
    private List<Topic_Set> topicSetList;
}
