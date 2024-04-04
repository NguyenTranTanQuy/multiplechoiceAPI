package com.group3.multiplechoiceAPI.Controller;

import com.group3.multiplechoiceAPI.Controller.Model.ResponseData;
import com.group3.multiplechoiceAPI.DTO.Tested_Assignment;
import com.group3.multiplechoiceAPI.Model.User;
import com.group3.multiplechoiceAPI.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public List<User> getAllUsers() {
        return userService.getAllStudents();
    }

    @GetMapping(path = "/{username}")
    public ResponseData getUser(@PathVariable("username") String username) {
        ResponseData responseData = new ResponseData();
        User user = userService.getUserByUsername(username);
        if (user != null) {
            responseData.setStatus(200);
            responseData.setMessage("Get user successfully");
            responseData.setData(user);
        } else {
            responseData.setStatus(500);
            responseData.setMessage("The username "+ username + " doesn't exists!");
        }

        return  responseData;
    }

    @PostMapping(path = "/account")
    @ResponseBody
    public ResponseData addAccount(@RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String phoneNumber) {
        boolean isSuccess = userService.addUser(username, password, phoneNumber);
        ResponseData responseData = new ResponseData();

        if(isSuccess) {
            responseData.setStatus(200);
            responseData.setMessage("Added account successfully");
        } else {
            responseData.setStatus(500);
            responseData.setMessage("The username "+ username + " does exists!");
        }

        return responseData;
    }

    @PutMapping(path = "/{username}")
    @ResponseBody
    public ResponseData updateUser(@RequestBody User user) {
        boolean isSuccess = userService.updateUser(user);

        ResponseData responseData = new ResponseData();
        if(isSuccess) {
            responseData.setStatus(200);
            responseData.setMessage("Updated user successfully");
        } else {
            responseData.setStatus(500);
            responseData.setMessage("The username " + user.getUsername() + " does not exists!");
        }

        return responseData;
    }

    @DeleteMapping(path = "/{username}")
    @ResponseBody
    public ResponseData deleteUser(@PathVariable("username") String username) {
        boolean isSuccess = userService.deleteUser(username);

        ResponseData responseData = new ResponseData();
        if(isSuccess) {
            responseData.setStatus(200);
            responseData.setMessage("Deleted user successfully");
        } else {
            responseData.setStatus(500);
            responseData.setMessage("The username " + username + " does not exists!");
        }

        return responseData;
    }

    @PostMapping(path = "/sign-in")
    @ResponseBody
    public ResponseData signIn(
            @RequestParam String username,
            @RequestParam String password) {
        boolean isSuccess = userService.signIn(username, password);

        ResponseData responseData = new ResponseData();
        if (isSuccess) {
            responseData.setStatus(200);
            responseData.setMessage("Sign in successfully");
        }
        else {
            responseData.setStatus(500);
            responseData.setMessage("Wrong username or password!");
        }

        return responseData;
    }

    @PutMapping(path = "/account")
    @ResponseBody
    public ResponseData resetPassword(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String phoneNumber) {
        boolean isSuccess = userService.resetPassword(username, password, phoneNumber);

        ResponseData responseData = new ResponseData();
        if (isSuccess) {
            responseData.setStatus(200);
            responseData.setMessage("Reset password successfully!");
        }
        else {
            responseData.setStatus(500);
            responseData.setMessage("Username or phone number is wrong!");
        }

        return responseData;
    }

    @GetMapping(path = "/tested-assignment/{username}")
    public ResponseData getTestByUsername(@PathVariable("username") String username) {
        ResponseData responseData = new ResponseData();
        List<Object[]> testedAssignment = userService.getTestByUsername(username);
        if (testedAssignment != null) {
            responseData.setStatus(200);
            responseData.setMessage("Get user successfully");
            responseData.setDataList(testedAssignment);
        } else {
            responseData.setStatus(500);
            responseData.setMessage("The tested assignment of "+ username + " doesn't exists!");
        }

        return  responseData;
    }

}
