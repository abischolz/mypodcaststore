package com.example.myPodcastStore.podcasts.services;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class PodcastService {


//    Dotenv dotEnv = Dotenv.load();
//    String apiKey = dotEnv.get("PODCAST_API_KEY");
    private String getTest() {
        String listenEndPoint = "https://listen-api-test.listennotes.com/api/v2";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(listenEndPoint +"/1", String.class);
        return result;
    }






    }

