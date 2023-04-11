package com.example.tidtagarur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StopwatchRepository extends JpaRepository<StopwatchEntity, UUID> {
}
