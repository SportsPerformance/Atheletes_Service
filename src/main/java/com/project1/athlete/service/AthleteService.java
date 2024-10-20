package com.project1.athlete.service;

import com.project1.athlete.dto.AthleteRequestDto;
import com.project1.athlete.model.Athletes;
import com.project1.athlete.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class AthleteService {


    private final AthleteRepository athleteRepository;
    private final FileStorageService fileStorageService; // Inject FileStorageService

    @Autowired
    public AthleteService(AthleteRepository athleteRepository, FileStorageService fileStorageService) {
        this.athleteRepository = athleteRepository;
        this.fileStorageService = fileStorageService; // Initialize FileStorageService
    }

    // 1. Athlete create Profile
    public Athletes createProfile(AthleteRequestDto athleteRequestDto, MultipartFile photo) {
        Athletes athlete = new Athletes();
        athlete.setFirstName(athleteRequestDto.getFirstName());
        athlete.setLastName(athleteRequestDto.getLastName());
        athlete.setBirthDate(LocalDate.parse(athleteRequestDto.getBirthDate()));
        athlete.setGender(athleteRequestDto.getGender());
        athlete.setHeight(athleteRequestDto.getHeight());
        athlete.setWeight(athleteRequestDto.getWeight());
        athlete.setCategory(athleteRequestDto.getCategory());

        // Handle file upload logic and set photoUrl
        if (photo != null && !photo.isEmpty()) {
            try {
                String photoUrl = fileStorageService.storeFile(photo, athleteRequestDto.getUserId()); // Use userId from athleteRequestDto
                athlete.setPhotoUrl(photoUrl);
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the error, you can also throw a custom exception or return a specific response if needed
                // For now, we will just return a response with an error message
                throw new RuntimeException("Failed to store photo: " + e.getMessage(), e);
            }
        }

        return athleteRepository.save(athlete);
    }

    // 2. Athlete getAthlete by full name
    public Athletes getAthlete(String name) {
        String[] names = name.split(" ", 2);
        if (names.length != 2) {
            throw new IllegalArgumentException("Full name must consist of first name and last name");
        }
        String firstName = names[0];
        String lastName = names[1];
        return athleteRepository.findByFullName(firstName, lastName);
    }

    // 3. Athlete getAthleteById
    public Athletes getAthleteById(int athleteId) {
        return athleteRepository.findById(athleteId).orElse(null);
    }

    // 4. List<Athlete> getAll
    public List<Athletes> getAll() {
        return athleteRepository.findAll();
    }

    public Athletes findAthleteByUserId(int userId) {
        return athleteRepository.findByUserId(userId);
    }

    public int findAthleteIdByUserId(int userId) {
        Athletes athlete = athleteRepository.findByUserId(userId);
        return athlete.getAthleteId();
    }
}
