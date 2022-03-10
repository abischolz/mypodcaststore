package com.example.myPodcastStore.model;


import javax.persistence.*;


public class Media {


    @Column(name="LISTEN_ID")

    public Long listenID;
    public Long getListenID() {
        return listenID;
    }

    public void setListenID(Long listenID) {
        this.listenID = listenID;
    }



    @Column(name="TITLE")

    private String title;

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="IMAGE")
    private String image;

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name="DESCRIPTION")
    private String descritpion;

    public String getDescritpion() {
        return this.descritpion;
    }
    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }


    @Column(name="WEBSITE")
    public String website;
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }

    @Column(name="THUMBNAIL")
    public String thumbnail;
    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;}






}