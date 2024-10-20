package com.project1.athlete.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AthleteRequestDto {
    private int userId;        // Added userId to uniquely identify the athlete
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;
    private float height;
    private float weight;
    private String category;
    private String photoUrl;   // Optionally store the photo URL here
}
