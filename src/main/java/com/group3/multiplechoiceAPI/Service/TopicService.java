package com.group3.multiplechoiceAPI.Service;

import com.group3.multiplechoiceAPI.Model.Topic;
import com.group3.multiplechoiceAPI.Repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TopicService {
    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }
    public List<Topic> getAllTopic(){
        return topicRepository.findAll();
    }
    public List<Topic> getTopicByUsername(String username){
        return topicRepository.findAllTopicByUsername(username);
    }
}
