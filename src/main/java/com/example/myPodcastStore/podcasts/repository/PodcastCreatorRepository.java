package com.example.myPodcastStore.podcasts.repository;

import com.example.myPodcastStore.podcasts.model.PodcastCreator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodcastCreatorRepository extends CrudRepository <PodcastCreator, Integer> {
}
