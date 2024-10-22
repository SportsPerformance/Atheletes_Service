package com.project1.athlete.repository;

import com.project1.athlete.model.Athletes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface  AthleteRepository extends JpaRepository<Athletes, Integer> {
    Athletes findByUserId(int userId);

    @Query("SELECT s FROM Athletes s WHERE s.firstName = :firstName AND s.lastName = :lastName")
    Athletes findByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
