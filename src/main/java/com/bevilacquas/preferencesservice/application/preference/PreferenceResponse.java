package com.bevilacquas.preferencesservice.application.preference;

import com.bevilacquas.preferencesservice.domain.entities.Preference;

import java.util.Optional;

import static java.util.Optional.of;

public record PreferenceResponse(Preference preference){ }