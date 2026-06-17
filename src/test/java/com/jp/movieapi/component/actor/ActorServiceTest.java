package com.jp.movieapi.component.actor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.jp.movieapi.component.actor.domain.Actor;
import com.jp.movieapi.component.actor.domain.ActorRepository;
import com.jp.movieapi.component.actor.service.ActorServiceImpl;
import com.jp.movieapi.internal.common.domain.ResourceNotFoundException;

@ExtendWith(MockitoExtension.class)
public class ActorServiceTest {
    @Mock
    private ActorRepository actorRepository;
    @InjectMocks
    private ActorServiceImpl actorService;

    private static Actor createActorOne() {
        return new Actor(UUID.fromString("11111111-1111-1111-1111-111111111111"), "John Doe",
                "01-01-2001");
    }

    private static Actor createActorTwo() {
        return new Actor(UUID.fromString("22222222-2222-2222-2222-222222222222"), "Jane Doe",
                "02-02-2002");
    }

    @Test
    void testListAllActors() {
        List<Actor> listOfActors =
                new ArrayList<Actor>(List.of(createActorOne(), createActorTwo()));
        when(actorRepository.findAllActors()).thenReturn(listOfActors);

        assertEquals(listOfActors, actorService.listAllActors());
    }

    @Test
    void testGetActorByExistingId() {
        UUID testUuid = UUID.fromString("11111111-1111-1111-1111-111111111111");
        Actor actor = createActorOne();
        when(actorRepository.findActorById(testUuid)).thenReturn(Optional.of(actor));

        assertEquals(actor, actorService.getActorById(testUuid));
    }

    @Test
    void testGetActorByNonExistentId() {
        UUID testUuid = UUID.fromString("33333333-3333-3333-3333-333333333333");
        when(actorRepository.findActorById(testUuid)).thenReturn(Optional.empty());
        String expectedMessage = "Actor with ID " + testUuid + " was not found.";

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
                () -> actorService.getActorById(testUuid));

        assertEquals(expectedMessage, exception.getMessage());
    }
}
