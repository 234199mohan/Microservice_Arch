package com.mohan.user.service.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "micro_users")
@Getter
@Setter
@Builder

public class User implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME", length = 15)
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ABOUT")
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();



    public User(String id, String name, String email, String about) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.about = about;
    }

    public User(String id, String name, String email, String about, List ratings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.about = about;
        this.ratings = ratings;
    }

    public User() {

    }
}
