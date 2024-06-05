package com.group3.multiplechoiceAPI.Service;

import com.group3.multiplechoiceAPI.DTO.Notification.NotificationResponse;
import com.group3.multiplechoiceAPI.DTO.User.Response.UserDtoResponse;
import com.group3.multiplechoiceAPI.Model.User;
import com.group3.multiplechoiceAPI.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        Optional<User> userByUsername =  userRepository.findByUsername(username);
        if (userByUsername.isEmpty()) return null;
        return userRepository.findByUsername(username).get();
    }

    public boolean addUser(String username, String password, String phoneNumber) {
        Optional<User> userByUsername =  userRepository.findByUsername(username);
        if (userByUsername.isPresent()) return false;

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);

        userRepository.save(user);
        return true;
    }

    public boolean updateUser(User user) {
        Optional<User> userByUsername =  userRepository.findByUsername(user.getUsername());
        if (userByUsername.isEmpty()) return false;

        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(String username) {
        Optional<User> userByUsername =  userRepository.findByUsername(username);
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
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) return false;
        if (!user.get().getPhoneNumber().equals(phoneNumber)) return false;
        userRepository.resetPassword(username, password);
        return true;
    }

    @Transactional()
    public List<Object> getTestByUsername(String username) {
        return userRepository.getTestByUsername(username);
    }

    @Transactional()
    public List<Object> getStatistic(String username) {
        return userRepository.getStatistic(username);
    }

    @Transactional()
    public List<Object> getTopicSetStatistic(String topic_set_code) {
        return userRepository.getTopicSetStatistic(topic_set_code);
    }

//    Trieu
    public List<UserDtoResponse> getFriends(String username) {
        User user = userRepository.findById(username).orElseThrow();
        return user.getFriendshipsAsUser2().stream().map(friendShip -> new UserDtoResponse(friendShip.getUser1().getUsername(),friendShip.getUser1().getName())).collect(Collectors.toList());
    }

    public List<NotificationResponse> getNotification(String username) {
        User user = userRepository.findById(username).orElseThrow();
        return user.getShareList().stream().map(
                item -> new NotificationResponse(item.getSharedDate().toString(),item.getShareContent())).collect(Collectors.toList());
    }

    public boolean updateUser2(String username, String name, String email, String phone) {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            return false;
        }

        User user = optionalUser.get();
        user.setName(name);
        user.setPhoneNumber(phone);
        user.setEmail(email);

        userRepository.save(user);

        return true;
    }
}
