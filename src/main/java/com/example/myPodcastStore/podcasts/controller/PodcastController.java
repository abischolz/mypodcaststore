package com.example.myPodcastStore.podcasts.controller;

import com.example.myPodcastStore.podcasts.repository.PodcastRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PodcastController {
    private final PodcastRepository podcastRepository;
    public PodcastController(final PodcastRepository podcastRepository) {
        this.podcastRepository = podcastRepository;
    }
}
