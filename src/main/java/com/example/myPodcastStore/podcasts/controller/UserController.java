package com.example.myPodcastStore.podcasts.controller;

import com.example.myPodcastStore.podcasts.repository.UserRepository;

public class UserController {
    private final UserRepository userRepository;
    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
