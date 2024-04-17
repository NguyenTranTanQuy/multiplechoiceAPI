package com.group3.multiplechoiceAPI.Controller;

import com.group3.multiplechoiceAPI.Controller.Model.ResponseData;
import com.group3.multiplechoiceAPI.Service.DetailedAssignmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/detailed-assignment")
public class DetailedAssignmentController {
    private final DetailedAssignmentService detailedAssignmentService;

    public DetailedAssignmentController(DetailedAssignmentService detailedAssignmentService) {
        this.detailedAssignmentService = detailedAssignmentService;
    }

    @PostMapping(path = "/")
    @ResponseBody
    public ResponseData addDetailedAssignment(@RequestParam Long assignmentID,
                                      @RequestParam Long questionID,
                                      @RequestParam String selectedAnswer) {
        boolean isSuccess = detailedAssignmentService.addDetailedAssignment(assignmentID, questionID, selectedAnswer);
        ResponseData responseData = new ResponseData();

        if(isSuccess) {
            responseData.setStatus(200);
            responseData.setMessage("Added detailed assignment successfully");
        } else {
            responseData.setStatus(500);
            responseData.setMessage("The assignment ID "+ assignmentID + " or question ID " + questionID + " does not exists!");
        }

        return responseData;
    }
}
