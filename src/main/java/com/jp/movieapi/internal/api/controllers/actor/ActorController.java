package com.jp.movieapi.internal.api.controllers.actor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.movieapi.component.actor.domain.Actor;
import com.jp.movieapi.component.actor.service.ActorService;
import com.jp.movieapi.internal.api.controllers.actor.dto.ActorResponse;

@RestController
@RequestMapping("/api/actors")
public class ActorController {
    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseEntity<List<ActorResponse>> getAllActors() {
        List<Actor> actors = actorService.listAllActors();
        List<ActorResponse> actorsResponse =
                actors.stream().map(this::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(actorsResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorResponse> getActorById(@PathVariable UUID id) {
        Actor actor = actorService.getActorById(id);
        return ResponseEntity.ok(toResponse(actor));
    }

    private ActorResponse toResponse(Actor actor) {
        return new ActorResponse(actor.getId(), actor.getName(), actor.getBirthDate());
    }
}
