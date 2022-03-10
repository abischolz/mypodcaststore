package com.example.myPodcastStore.repository;

import com.example.myPodcastStore.model.Library;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends CrudRepository <Library, Integer> {
}
