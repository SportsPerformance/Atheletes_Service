package com.project1.athlete.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Athletes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int athleteId;
    private int userId;          // Identifies the user associated with the athlete
    private String firstName;
    private String lastName;
    private LocalDate birthDate; // Assuming this is handled as a `LocalDate`
    private String gender;
    private float height;
    private float weight;
    private String category;
    private int coachId;         // If a coach is assigned, their ID will be stored here
    private String photoUrl;     // URL or path to the stored photo file

    // You could also include additional fields related to the athlete's performance, if needed.
}
