package com.project1.athlete.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Athletes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int athleteId;
    private int userId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;
    private float height;
    private float weight;
    private String category;
    private int coachId;
    private String photoUrl;
}
