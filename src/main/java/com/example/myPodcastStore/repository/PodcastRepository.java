package com.example.myPodcastStore.repository;

import com.example.myPodcastStore.model.Podcast;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodcastRepository extends CrudRepository <Podcast, Integer> {
}
