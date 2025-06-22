package com.jp.movieapi.internal.api.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.movieapi.component.health.HealthService;
import com.jp.movieapi.component.health.model.HealthStatus;

@RestController
public class HealthController {

    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping("/health")
    public HealthStatus getHealthStatus() {
        return healthService.checkHealth();
    }
}
