package com.group3.multiplechoiceAPI.Controller;

import com.group3.multiplechoiceAPI.DTO.Selection.SelectionConverter;
import com.group3.multiplechoiceAPI.DTO.Selection.SelectionDTO;
import com.group3.multiplechoiceAPI.Model.Question;
import com.group3.multiplechoiceAPI.Model.Selection;
import com.group3.multiplechoiceAPI.Service.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/selection")
public class SelectionController {

    private final SelectionService selectionService;

    @Autowired
    public SelectionController(SelectionService selectionService) {
        this.selectionService = selectionService;
    }


    @GetMapping(path = "/{questionCode}")
    public List<SelectionDTO> getSelectionByQuestionID(@PathVariable("questionCode") Long questionID){
        return selectionService.getAllQuestionsByQuestionID(questionID).stream().map(SelectionConverter::toDTO).collect(Collectors.toList());
    }
}

