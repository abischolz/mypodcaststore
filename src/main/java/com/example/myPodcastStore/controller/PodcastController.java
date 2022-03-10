package com.example.myPodcastStore.controller;

import com.example.myPodcastStore.model.Podcast;
import com.example.myPodcastStore.repository.PodcastRepository;
import com.example.myPodcastStore.services.PodcastService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.listennotes.podcast_api.exception.ListenApiException;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class PodcastController {
    private final PodcastRepository podcastRepository;
    private final PodcastService podcastService;


    public PodcastController(final PodcastRepository podcastRepository, final PodcastService podcastService) {
        this.podcastRepository = podcastRepository;
        this.podcastService = podcastService;
    };
    String listenEndPoint = "https://listen-api-test.listennotes.com/api/v2";


    @GetMapping("/podcasts")
    private Object getBestPodcasts() throws JsonProcessingException {
        System.out.println("==== get podcasts ====");

        String response = podcastService.getBestPodcasts();
        ObjectMapper objectMapper = new ObjectMapper();

        Object responseJava = objectMapper.readValue(response, Object.class);
        return responseJava;
    }



    @GetMapping("/{id}")
    public Podcast getPodcastById(@PathVariable("id") Integer id) throws JsonProcessingException, ListenApiException {
        System.out.println("==== get podcast ====");

        String response = podcastService.getPodcastById(id);
        ObjectMapper objectMapper = new ObjectMapper();


        Podcast podcast = objectMapper.readValue(response, Podcast.class);
        return podcast;

    }
}
