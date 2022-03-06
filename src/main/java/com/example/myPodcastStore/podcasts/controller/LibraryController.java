package com.example.myPodcastStore.podcasts.controller;

import com.example.myPodcastStore.podcasts.repository.LibraryRepository;
import org.apache.tomcat.jni.Library;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class LibraryController {
        private final LibraryRepository libraryRepository;
        public LibraryController(final LibraryRepository libraryRepository) {
            this.libraryRepository = libraryRepository;
        }
//
//        @GetMapping("/{id}")
//        public Library getLibrary(@RequestParam("id") Integer id)
}
