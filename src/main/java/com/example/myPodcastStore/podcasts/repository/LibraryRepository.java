package com.example.myPodcastStore.podcasts.repository;

import com.example.myPodcastStore.podcasts.model.Library;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends CrudRepository <Library, Integer> {
}
