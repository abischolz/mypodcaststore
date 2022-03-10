package com.example.myPodcastStore.model;

import javax.persistence.*;

//this is coming from a 3rd party API - do i need to save this? current answer: i think so, because i'm using a custom



@Entity
@Table(name = "PODCASTS")
public class Podcast  extends Media {
    @Id
    @GeneratedValue
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="COUNTRY")
    private String country;

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name="LANGUAGE")
    public String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Column(name="PUBLISHER")
    public String publisher;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Column(name="TOTAL_EPISIDES")
    public Integer totalEpisodes;
    public Integer getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(Integer totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

}
