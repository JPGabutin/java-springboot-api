package com.jp.movieapi.component.actor.domain;

import java.util.UUID;

public class Actor {
    private UUID id;
    private String name;
    private String birthDate;

    public Actor() {}


    public Actor(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Actor(UUID id, String name, String birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
