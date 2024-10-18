package com.project1.athlete.repository;

import com.project1.athlete.model.Athletes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athletes, Integer> {
    Athletes findByUserId(int userId);
}
