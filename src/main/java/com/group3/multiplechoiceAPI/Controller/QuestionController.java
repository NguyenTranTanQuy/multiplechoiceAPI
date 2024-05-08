package com.group3.multiplechoiceAPI.Controller;

import com.group3.multiplechoiceAPI.DTO.Question.QuestionConverter;
import com.group3.multiplechoiceAPI.DTO.Question.QuestionDTO;
import com.group3.multiplechoiceAPI.Model.Question;
import com.group3.multiplechoiceAPI.Model.Selection;
import com.group3.multiplechoiceAPI.Service.QuestionService;
import com.group3.multiplechoiceAPI.Service.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {

    private final QuestionService questionService;
    private final SelectionService selectionService;


    @Autowired
    public QuestionController(QuestionService questionService, SelectionService selectionService) {
        this.questionService = questionService;
        this.selectionService = selectionService;
    }

    @GetMapping(path = "/all")
    public List<QuestionDTO> getAllQuestion(){return questionService.getAllQuestion().stream().map(QuestionConverter::toDTO).collect(Collectors.toList());}
    @GetMapping(path = "/{topic_set_code}")
    public List<QuestionDTO> getQuestionByTopicSetID(@PathVariable("topic_set_code") Long topicSetID){
        return (List<QuestionDTO>) questionService.getAllQuestionsByTopicSetID(topicSetID).stream().map(QuestionConverter::toDTO).collect(Collectors.toList());
    }

    @GetMapping(path = "/q/{questionCode}")
    public Question getSelectionByQuestionID(@PathVariable("questionCode") Long questionCode){
        return questionService.getQuestionByID(questionCode);
    }
}


