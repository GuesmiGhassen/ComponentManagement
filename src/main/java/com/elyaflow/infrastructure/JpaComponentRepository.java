package com.elyaflow.infrastructure;

import com.elyaflow.domain.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaComponentRepository extends JpaRepository<Component, UUID> {
}
