package com.jp.movieapi.internal.api.controllers.actor.dto;

import java.util.UUID;

public record ActorResponse(UUID id, String name, String birthDate) {
}
