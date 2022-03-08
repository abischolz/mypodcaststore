package com.example.myPodcastStore.podcasts.controller;

import com.example.myPodcastStore.podcasts.model.Podcast;
import com.example.myPodcastStore.podcasts.repository.PodcastRepository;
import com.example.myPodcastStore.podcasts.services.PodcastService;
import com.listennotes.podcast_api.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class PodcastController {
    private final PodcastRepository podcastRepository;
    private final PodcastService podcastService;


    public PodcastController(final PodcastRepository podcastRepository, final PodcastService podcastService) {
        this.podcastRepository = podcastRepository;
        this.podcastService = podcastService;
    }
    String listenEndPoint = "https://listen-api-test.listennotes.com/api/v2";

//    @GetMapping("/podcasts")
//    public ArrayList<Podcast> getBestPodcasts() {
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(listenEndPoint + "", String.class);
//        return result;
//
//    }

    @GetMapping("/test")
    private void getTest() {
        ApiResponse response = podcastService.getTest();
        System.out.println(response.toJSON().toString(2));

    }


    public Iterable<Podcast> getAllPodcasts() {
        return podcastRepository.findAll();
    }

    @GetMapping("/{id}")
    public Podcast getPodcastById(@RequestParam("id") Integer id) {
        Optional<Podcast> getPodcastByIdOptional = this.podcastRepository.findById(id);
        if(!getPodcastByIdOptional.isPresent()) {
            return null;
        }
        Podcast foundPodcast = getPodcastByIdOptional.get();
        return foundPodcast;
    }
}
