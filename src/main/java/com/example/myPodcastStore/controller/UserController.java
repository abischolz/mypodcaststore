package com.example.myPodcastStore.controller;

import com.example.myPodcastStore.model.User;
import com.example.myPodcastStore.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/account")
public class UserController {
    private final UserRepository userRepository;
    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public User getUserById(@RequestParam("id") Integer id) {
        Optional<User> findUserOptional = this.userRepository.findById(id);
        if (!findUserOptional.isPresent()) {
            return null;
        }
        User foundUser = findUserOptional.get();
        return foundUser;
    }

}
