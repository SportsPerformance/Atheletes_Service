package com.project1.athlete.service;

import com.project1.athlete.dto.AthleteRequestDto;
import com.project1.athlete.model.Athletes;
import com.project1.athlete.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Service
public class AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;

    // 1. Athlete create Profile
    public Athletes createProfile(AthleteRequestDto athleteRequestDto, String photoUrl, MultipartFile photo) {
        Athletes athlete = new Athletes();
        athlete.setUserId(athleteRequestDto.getUserId());
        athlete.setFirstName(athleteRequestDto.getFirstName());
        athlete.setLastName(athleteRequestDto.getLastName());
        athlete.setBirthDate(LocalDate.parse(athleteRequestDto.getBirthDate()));
        athlete.setGender(athleteRequestDto.getGender());
        athlete.setHeight(athleteRequestDto.getHeight());
        athlete.setWeight(athleteRequestDto.getWeight());
        athlete.setCategory(athleteRequestDto.getCategory());
        athlete.setCoachId(athleteRequestDto.getCoachId());
        athlete.setPhotoUrl(photoUrl); // Handle file upload logic separately
        return athleteRepository.save(athlete);
    }

    // 2. Athlete getAthlete by user ID
    public Athletes getAthlete(int userId) {
        return athleteRepository.findByUserId(userId);
    }

    // 3. Athlete getAthleteById
    public Athletes getAthleteById(int athleteId) {
        return athleteRepository.findById(athleteId).orElse(null);
    }

    // 4. List<Athlete> getAll
    public List<Athletes> getAll() {
        return athleteRepository.findAll();
    }
}
