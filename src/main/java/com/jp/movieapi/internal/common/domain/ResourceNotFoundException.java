package com.jp.movieapi.internal.common.domain;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, UUID id) {
        super(resourceName + " with ID " + id + " was not found.");
    }
}
