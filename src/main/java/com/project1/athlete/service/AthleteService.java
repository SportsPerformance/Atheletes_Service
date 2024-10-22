package com.project1.athlete.service;

import com.project1.athlete.dto.AthleteRequestDto;
import com.project1.athlete.model.Athletes;
import com.project1.athlete.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;

    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    // 1. Athlete create Profile
    public Athletes createProfile(AthleteRequestDto athleteRequestDto, MultipartFile photo) throws IOException {

        String FOLDER_PATH = "C:/Users/LENOVO/Downloads/athlete/athlete/src/main/java/com/project1athlete/Img/";
        String filePath = FOLDER_PATH+photo.getOriginalFilename();
        photo.transferTo(new File(filePath));

        Athletes athlete = new Athletes();
        athlete.setFirstName(athleteRequestDto.getFirstName());
        athlete.setLastName(athleteRequestDto.getLastName());
        athlete.setBirthDate(LocalDate.parse(athleteRequestDto.getBirthDate()));
        athlete.setGender(athleteRequestDto.getGender());
        athlete.setHeight(athleteRequestDto.getHeight());
        athlete.setWeight(athleteRequestDto.getWeight());
        athlete.setCategory(athleteRequestDto.getCategory());
        athlete.setPhotoUrl(filePath);
        return athleteRepository.save(athlete);
    }

    // 2. Athlete getAthlete by full name
    public Athletes getAthlete(String name) {
        String[] names = name.split(" ", 2);
        if (names.length != 2){
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

    public Athletes findAthleteByUserId(int userId){
        return athleteRepository.findByUserId(userId);
    }

    public int findAthleteIdByUserId(int userId){
        Athletes athlete = athleteRepository.findByUserId(userId);
        return athlete.getAthleteId();
    }
}
