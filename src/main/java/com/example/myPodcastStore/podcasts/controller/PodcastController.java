package com.example.myPodcastStore.podcasts.controller;

import com.example.myPodcastStore.podcasts.model.Podcast;
import com.example.myPodcastStore.podcasts.repository.PodcastRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@RestController
public class PodcastController {
    private final PodcastRepository podcastRepository;
    public PodcastController(final PodcastRepository podcastRepository) {
        this.podcastRepository = podcastRepository;
    }

    @GetMapping("/podcasts")
    public String findURI() {
        return "you found me";
    }

    @GetMapping("/test")
    private String getTest() {
        String listenEndPoint = "https://listen-api-test.listennotes.com/api/v2";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(listenEndPoint + "", String.class);
        return result;
    }


//    public Iterable<Podcast> getAllPodcasts() {
//        return podcastRepository.findAll();
//    }

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
