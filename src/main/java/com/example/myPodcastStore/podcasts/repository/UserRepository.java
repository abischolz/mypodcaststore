package com.example.myPodcastStore.podcasts.repository;

import com.example.myPodcastStore.podcasts.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Integer> {
}
