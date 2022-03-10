package com.example.myPodcastStore.controller;

import com.example.myPodcastStore.model.Podcast;
import com.example.myPodcastStore.repository.PodcastRepository;
import com.example.myPodcastStore.services.PodcastService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.listennotes.podcast_api.exception.ListenApiException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Object responseJava = objectMapper.readValue(response, Object.class);
        return responseJava;
    }



    @GetMapping("/podcasts/{id}")
    public Podcast getPodcastById(@PathVariable("id") String id) throws JsonProcessingException, ListenApiException {
        System.out.println("==== get podcast ====");

        String response = podcastService.getPodcastById(id);
        System.out.println(response);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);



        Podcast podcast = objectMapper.readValue(response, Podcast.class);
        return podcast;

    }

    @GetMapping("/podcasts/search")
    public Object searchPodcasts(@RequestParam(required = true) HashMap<String, String> parameters) throws ListenApiException, JsonProcessingException {

        System.out.println("==== search podcasts ====");

        String response = podcastService.searchPodcasts(parameters);

        ObjectMapper objectMapper = new ObjectMapper();
        Object responseJava = objectMapper.readValue(response, Object.class);
        return responseJava;

    }

    @PostMapping("/add")
    public Podcast addPodcast(@RequestBody(required = true) Podcast podcast) {
        System.out.println("==== add podcast ====");

        Podcast newPodcast = podcastRepository.save(podcast);
        return newPodcast;
    }

    @DeleteMapping("/podcasts/{id}/delete")
    public Podcast deletePodcast(@PathVariable("id") String id) throws ListenApiException, JsonProcessingException {
        System.out.println("==== delete podcast ====");
        String response = podcastService.deletePodcast(id);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Podcast deletedPodcast = objectMapper.readValue(response, Podcast.class);
        return deletedPodcast;

    }

    @PutMapping("/podcasts/{id}/like")
    public Podcast likePodcast(@PathVariable("id") String id) {
        System.out.println("==== like podcast ====");
        Podcast podcast = podcastService.likePodcast(id);
        return podcast;

    }


}
