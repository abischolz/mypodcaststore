package com.example.myPodcastStore.repository;

import com.example.myPodcastStore.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Integer> {
}
