package com.example.myPodcastStore.podcasts.repository;

import com.example.myPodcastStore.podcasts.model.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository <Library, Integer> {
}
