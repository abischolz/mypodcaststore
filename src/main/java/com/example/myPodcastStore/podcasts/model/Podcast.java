package com.example.myPodcastStore.podcasts.model;

import javax.persistence.*;

@Entity
@Table(name = "PODCASTS")
public class Podcast {
    @Id
    @GeneratedValue
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="NAME")
    private String name;

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
