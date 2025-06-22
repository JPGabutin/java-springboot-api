package com.jp.movieapi.component.health;

import com.jp.movieapi.component.health.model.HealthStatus;
import org.springframework.stereotype.Service;

@Service
public class HealthService {

    public HealthStatus checkHealth() {
        return new HealthStatus("OK");
    }
}
