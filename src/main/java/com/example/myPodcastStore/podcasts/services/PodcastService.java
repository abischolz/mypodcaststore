package com.example.myPodcastStore.podcasts.services;

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


    public ApiResponse getTest() {
        try {
            String apiKey = this.dotenv.get("PODCAST_API_KEY");
            Client objClient = new Client(apiKey);

            HashMap<String, String> parameters = new HashMap<>();
            parameters.put("id", "4d3fe717742d4963a85562e9f84d8c79");
            ApiResponse response = objClient.fetchPodcastById(parameters);
            System.out.println(response.toJSON().toString(2));
            return response;
        } catch (ListenApiException e) {
            e.printStackTrace();
        }
        return null;
    }






    }

