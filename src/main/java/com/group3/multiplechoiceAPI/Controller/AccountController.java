package com.group3.multiplechoiceAPI.Controller;

import com.group3.multiplechoiceAPI.Controller.Model.ResponseData;
import com.group3.multiplechoiceAPI.Service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
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
            responseData.setStatus(400);
            responseData.setMessage("Wrong username or password!");
        }

        return responseData;
    }

    @PostMapping(path = "/sign-up")
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
            responseData.setStatus(301);
            responseData.setMessage("The username "+ username + " does exists!");
        }

        return responseData;
    }

    @PutMapping(path = "/")
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
            responseData.setStatus(400);
            responseData.setMessage("Username or phone number is wrong!");
        }

        return responseData;
    }
}
