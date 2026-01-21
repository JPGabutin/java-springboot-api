package com.jp.movieapi.component.actor.domain;

import java.util.UUID;

public class Actor {
    private UUID id;
    private String name;
    private String birth_date;

    public Actor(UUID id, String name, String birthDate) {
        this.id = id;
        this.name = name;
        this.birth_date = birthDate;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birth_date;
    }
}
