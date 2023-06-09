package com.bevilacquas.preferencesservice.domain.entities;

import static java.util.UUID.randomUUID;

import com.bevilacquas.preferencesservice.application.user.UserRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity(name = "UserApp")
public class User {

    @Id
    private UUID id;

    @Column
    private String name;

    @SuppressWarnings("unused")
    public User(){}

    public User(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static User buildFromUserRequest(UserRequest ur) {
        return new User(randomUUID(), ur.name());
    }
}
