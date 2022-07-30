package com.example.lms_Clone.model;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class EntityAuditAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Pavan Kalyan");
    }
}
