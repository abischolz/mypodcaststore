package com.example.myPodcastStore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;


//this is coming from a 3rd party API - do i need to save this? current answer: i think so, because i'm using a custom



@Entity
@Table(name = "PODCASTS")
@JsonIgnoreProperties
public class Podcast  extends Media {
    @Id
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
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
    public Integer total_episodes;
    public Integer getTotalEpisodes() {
        return total_episodes;
    }

    public void setTotalEpisodes(Integer total_episodes) {
        this.total_episodes = total_episodes;
    }

    @Transient
    private ArrayList<Object> episodes;

    public Integer getTotal_episodes() {
        return total_episodes;
    }

    public void setTotal_episodes(Integer total_episodes) {
        this.total_episodes = total_episodes;
    }

    public ArrayList<Object> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<Object> episodes) {
        this.episodes = episodes;
    }
}
