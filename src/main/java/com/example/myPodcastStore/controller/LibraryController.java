package com.example.myPodcastStore.controller;

import com.example.myPodcastStore.repository.LibraryRepository;
import org.springframework.web.bind.annotation.RequestMapping;
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
