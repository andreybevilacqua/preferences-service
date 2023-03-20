package com.bevilacquas.preferencesservice.application.preference.response;

import com.bevilacquas.preferencesservice.domain.entities.User;
import java.util.UUID;

public record UserResponse(UUID id, String name) {
    public static UserResponse buildFromUser(User u) {
        return new UserResponse(u.getId(), u.getName());
    }
}
