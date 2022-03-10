package com.example.myPodcastStore.model;

import javax.persistence.*;
import java.util.Date;

//this is coming from a 3rd party API - do i need to save this? current answer: i think so, because i'm using a custom


@Entity
@Table(name = "EPISODE")
public class Episode extends Media {

    @Id
    @GeneratedValue
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name="LINK")
    private String link;
    @Column(name="DATE_PUBLISHED")
    private Date datePublished;
    @Column(name="AUDIO")
    private String audio;
    @Column(name="TRANSCRIPT")
    private String transcript;


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }
}
