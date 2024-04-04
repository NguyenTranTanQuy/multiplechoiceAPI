package com.group3.multiplechoiceAPI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Share {
    @EmbeddedId
    private ShareKey id;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(name="username")
    private User user;

    @ManyToOne
    @MapsId("topicSetCode")
    @JoinColumn(name="topicSetCode")
    private Topic_Set topicSet;

    private Date sharedDate;
    private String shareContent;
}
