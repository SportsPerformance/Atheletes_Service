package com.project1.athlete.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AthleteRequestDto {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;
    private float height;
    private float weight;
    private String category;
    // Optionally add other fields if needed
}
