package com.example.myPodcastStore.podcasts.model;

import javax.persistence.*;

@Entity
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="EMAIL")
    private String email;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "FIRST_NAME")
    private String firstName;

    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "LAST_NAME")
    private String lastName;

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="FIREBASE_ID")
    private String firebaseId;

    public String getFirebaseId() {
        return this.firebaseId;
    }

    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
    }

    @Column(name="USER_NAME")
    private String userName;

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
