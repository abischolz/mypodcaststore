package com.example.myPodcastStore.podcasts.model;

import javax.persistence.*;

//this could be an extension of the podcast class - they share the same information, but epidode has additional data
@Entity
@Table(name="EPISODES")
public class Episode {
    @Id
    @GeneratedValue
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
