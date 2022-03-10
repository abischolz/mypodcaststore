package com.example.myPodcastStore.services;

import com.example.myPodcastStore.model.Podcast;
import com.example.myPodcastStore.repository.PodcastRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.listennotes.podcast_api.ApiResponse;
import com.listennotes.podcast_api.Client;
import com.listennotes.podcast_api.exception.ListenApiException;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class PodcastService {
    private final Dotenv dotenv = Dotenv.load();
    private final String apiKey = dotenv.get("PODCAST_API_KEY");
    private final PodcastRepository podcastRepository;
    String listenEndPoint = "https://listen-api-test.listennotes.com/api/v2";

    public PodcastService(final PodcastRepository podcastRepository) {
        this.podcastRepository = podcastRepository;
    }

    public String getBestPodcasts() {
        try {
            Client objClient = new Client("");

            HashMap<String, String> parameters = new HashMap<>();
            parameters.put("page", "1");


            ApiResponse response = objClient.fetchBestPodcasts(parameters);
            return response.toJSON().toString();
        } catch (ListenApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getPodcastById(String id) throws ListenApiException {

        try {
            Client objClient = new Client("");

            HashMap<String, String> parameters = new HashMap<>();
            parameters.put("id", id);


            ApiResponse response = objClient.fetchPodcastById(parameters);
            return response.toJSON().toString();

        } catch (ListenApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String searchPodcasts(HashMap<String, String> parameters) {
        try {
            Client objClient = new Client("");
            ApiResponse apiResponse = objClient.search(parameters);
            System.out.println(apiResponse.getFreeQuota());
            return apiResponse.toJSON().toString();

        } catch (ListenApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deletePodcast(String podcast) {
        try {
            HashMap<String, String> reason = new HashMap<>();
            reason.put("reason", "testing");
            Client objClient = new Client("");
            ApiResponse apiResponse = objClient.deletePodcast(reason);
            return apiResponse.toJSON().toString();


        } catch (ListenApiException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Podcast likePodcast(String id) {
        try {
            Optional<Podcast> podcast = podcastRepository.findById(id);
            if (podcast.isPresent()) {
                Podcast foundPodcast = podcast.get();
                foundPodcast.setLikes(foundPodcast.getLikes() + 1);
                podcastRepository.save(foundPodcast);
                return foundPodcast;
            } else {
                String podcastFromAPI = this.getPodcastById(id);
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                Podcast newSavedPodcast = objectMapper.readValue(podcastFromAPI, Podcast.class);
                newSavedPodcast.setLikes(1);
                podcastRepository.save(newSavedPodcast);
                return newSavedPodcast;

            }

        } catch (ListenApiException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }





    }

