package com.example.myPodcastStore.services;

import com.example.myPodcastStore.model.Podcast;
import com.listennotes.podcast_api.ApiResponse;
import com.listennotes.podcast_api.Client;
import com.listennotes.podcast_api.exception.ListenApiException;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PodcastService {
    private final Dotenv dotenv = Dotenv.load();
    private final String apiKey = dotenv.get("PODCAST_API_KEY");
    String listenEndPoint = "https://listen-api-test.listennotes.com/api/v2";


    public String getBestPodcasts() {
        try {
            Client objClient = new Client(apiKey);

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
            Client objClient = new Client(apiKey);

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
            Client objClient = new Client(apiKey);
            ApiResponse apiResponse = objClient.search(parameters);
            return apiResponse.toJSON().toString();

        } catch (ListenApiException e) {
            e.printStackTrace();
        }
        return null;
    }







    }

