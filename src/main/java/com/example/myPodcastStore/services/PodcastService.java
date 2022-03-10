package com.example.myPodcastStore.services;

import com.listennotes.podcast_api.ApiResponse;
import com.listennotes.podcast_api.Client;
import com.listennotes.podcast_api.exception.ListenApiException;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PodcastService {
    private final Dotenv dotenv = Dotenv.load();
    String listenEndPoint = "https://listen-api-test.listennotes.com/api/v2";


    public String getBestPodcasts() {
        try {
            String apiKey = this.dotenv.get("PODCAST_API_KEY");
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

    public String getPodcastById(Integer id) throws ListenApiException {

        try {
            String apiKey = this.dotenv.get("PODCAST_API_KEY");
            Client objClient = new Client(apiKey);

            HashMap<String, String> parameters = new HashMap<>();
            parameters.put("id", id.toString());


            ApiResponse response = objClient.fetchPodcastById(parameters);
            return response.toJSON().toString();

        } catch (ListenApiException e) {
            e.printStackTrace();
        }
        return null;
    }






    }

