package com.example.myPodcastStore.podcasts.repository;

import com.example.myPodcastStore.podcasts.model.Podcast;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodcastRepository extends CrudRepository <Podcast, Integer> {
}
