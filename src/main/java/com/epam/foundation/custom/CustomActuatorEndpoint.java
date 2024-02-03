package com.epam.foundation.custom;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Endpoint(id = "app-info")
@Component
public class CustomActuatorEndpoint {

    private final Environment env;

    public CustomActuatorEndpoint(Environment env) {
        this.env = env;
    }


    @ReadOperation
    public Map<String, String> customEndpoint() {
        String activeProfiles = String.join(", ", env.getActiveProfiles());

        return Map.of(
                "ACTIVE_PROFILES", activeProfiles,
                "DB_URL", Objects.requireNonNull(env.getProperty("spring.datasource.url"))
        );
    }

}
