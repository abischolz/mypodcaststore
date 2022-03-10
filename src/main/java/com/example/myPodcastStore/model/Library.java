package com.example.myPodcastStore.model;

import com.example.myPodcastStore.LibraryType;

import javax.persistence.*;

@Entity
@Table(name="LIBRARIES")
public class Library {
    @Id
    @GeneratedValue
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name="TYPE")
    private LibraryType type;

    public LibraryType getType() {
        return this.type;
    }

    public void setType(LibraryType type) {
        this.type = type;
    }

}
