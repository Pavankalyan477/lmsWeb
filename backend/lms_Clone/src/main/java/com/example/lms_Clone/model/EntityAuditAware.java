package com.example.lms_Clone.model;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class EntityAuditAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
//        return Optional.ofNullable(SecurityContextHolder.getContext())
//                .map(e -> e.getAuthentication())
//                .map(Authentication::getName);
//        if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null
//                && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
//            return (Optional<String>) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        }
//        return Optional.empty();
        return Optional.of("PavanKalyan");
    }
}
