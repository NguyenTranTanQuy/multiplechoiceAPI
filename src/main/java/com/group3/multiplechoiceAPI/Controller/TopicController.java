package com.group3.multiplechoiceAPI.Controller;

import com.group3.multiplechoiceAPI.DTO.Topic.TopicConverter;
import com.group3.multiplechoiceAPI.DTO.Topic.TopicDTO;
import com.group3.multiplechoiceAPI.DTO.TopicSet.TopicSetConverter;
import com.group3.multiplechoiceAPI.Model.Assignment;
import com.group3.multiplechoiceAPI.Model.Topic;
import com.group3.multiplechoiceAPI.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/topic")
public class TopicController {

    private final TopicService topicService;


    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/all")
    public List<Topic> getAll(){
        return topicService.getAllTopic();
    }

    @GetMapping(path = "/find")
    public List<TopicDTO> getQuestionByTopicSet(@RequestParam("username") String username){
        return topicService.getTopicByUsername(username).stream().map(TopicConverter::toDTO).collect(Collectors.toList());
    }

}
