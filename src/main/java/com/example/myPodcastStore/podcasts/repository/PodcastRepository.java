package com.example.myPodcastStore.podcasts.repository;

import com.example.myPodcastStore.podcasts.model.Podcast;
import org.springframework.data.repository.CrudRepository;

public interface PodcastRepository extends CrudRepository <Podcast, Integer> {
}
