package com.project1.athlete.dto;

import lombok.Data;

@Data
public class AthleteRequestDto {
    private int userId;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;
    private float height;
    private float weight;
    private String category;
    private int coachId;
    // Optionally add other fields if needed
}
