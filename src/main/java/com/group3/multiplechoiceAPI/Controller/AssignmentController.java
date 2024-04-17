package com.group3.multiplechoiceAPI.Controller;

import com.group3.multiplechoiceAPI.Controller.Model.ResponseData;
import com.group3.multiplechoiceAPI.Repository.AssignmentRepository;
import com.group3.multiplechoiceAPI.Service.AssignmentService;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

@RestController
@RequestMapping("/api/v1/assignment")
public class AssignmentController {
    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping(path = "/")
    @ResponseBody
    public ResponseData addAssignment(@RequestParam float duration,
                                   @RequestParam Long topicSetID,
                                   @RequestParam String username) {
        boolean isSuccess = assignmentService.addAssignment(duration, topicSetID, username);
        ResponseData responseData = new ResponseData();

        if(isSuccess) {
            responseData.setStatus(200);
            responseData.setMessage("Added assignment successfully");
        } else {
            responseData.setStatus(500);
            responseData.setMessage("The username "+ username + " or topic set ID " + topicSetID + " does not exists!");
        }

        return responseData;
    }
}
