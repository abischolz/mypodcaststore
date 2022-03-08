package com.example.myPodcastStore.podcasts.controller;

import com.example.myPodcastStore.podcasts.model.Podcast;
import com.example.myPodcastStore.podcasts.repository.PodcastRepository;
import com.listennotes.podcast_api.ApiResponse;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.listennotes.podcast_api.Client;
import com.listennotes.podcast_api.exception.ListenApiException;




import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class PodcastController {
    private final PodcastRepository podcastRepository;
    public PodcastController(final PodcastRepository podcastRepository) {
        this.podcastRepository = podcastRepository;
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
        try {
            Dotenv apiKey = Dotenv.load();
            Client objClient = new Client(apiKey.get("PODCAST_API_KEY"));

            HashMap<String, String> parameter = new HashMap<>();
            parameter.put("id", "4d3fe717742d4963a85562e9f84d8c79");
            ApiResponse response = objClient.fetchPodcastById(parameter);
            System.out.println(response.toJSON().toString(2));

        } catch (ListenApiException e) {
            e.printStackTrace();
        }

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
