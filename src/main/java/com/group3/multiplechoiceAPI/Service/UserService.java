package com.group3.multiplechoiceAPI.Service;

import com.group3.multiplechoiceAPI.DTO.Tested_Assignment;
import com.group3.multiplechoiceAPI.Model.User;
import com.group3.multiplechoiceAPI.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllStudents() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        Optional<User> userByUsername =  userRepository.findUserByUsername(username);
        if (userByUsername.isEmpty()) return null;
        return userRepository.findUserByUsername(username).get();
    }

    public boolean addUser(String username, String password, String phoneNumber) {
        Optional<User> userByUsername =  userRepository.findUserByUsername(username);
        if (userByUsername.isPresent()) return false;

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);

        userRepository.save(user);
        return true;
    }

    public boolean updateUser(User user) {
        Optional<User> userByUsername =  userRepository.findUserByUsername(user.getUsername());
        if (userByUsername.isEmpty()) return false;

        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(String username) {
        Optional<User> userByUsername =  userRepository.findUserByUsername(username);
        if (userByUsername.isEmpty()) return false;

        userRepository.deleteByUsername(username);
        return true;
    }

    public boolean signIn(String username, String password) {
        List<User> userList = userRepository.findAll();

        for (User user:userList) {
           if (user.getUsername().equals(username) && user.getPassword().equals(password))
               return true;
        }
        return false;
    }

    public boolean resetPassword(String username, String password, String phoneNumber) {
        Optional<User> user = userRepository.findUserByUsername(username);
        if (user.isEmpty()) return false;
        if (!user.get().getPhoneNumber().equals(phoneNumber)) return false;
        userRepository.resetPassword(username, password);
        return true;
    }

    @Transactional()
    public List<Object[]> getTestByUsername(String username) {
        List<Object[]> testedAssignmentOfUsername = userRepository.getTestByUsername(username);
        return testedAssignmentOfUsername;
    }
}
