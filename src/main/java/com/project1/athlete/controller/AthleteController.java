package com.project1.athlete.controller;

import com.project1.athlete.dto.AthleteRequestDto;
import com.project1.athlete.model.Athletes;
import com.project1.athlete.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/athletes")
public class AthleteController {

    @Autowired
    private AthleteService athleteService;

    // 1. Create Athlete Profile
    @PostMapping
    public ResponseEntity<Athletes> createProfile(
            @RequestBody AthleteRequestDto athleteRequestDto,
            @RequestParam(value = "photo", required = false) MultipartFile photo) {
        Athletes athlete = athleteService.createProfile(athleteRequestDto, null, photo); // Implement photo handling
        return ResponseEntity.ok(athlete);
    }

    // 2. Get Athlete by User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<Athletes> getAthlete(@PathVariable int userId) {
        Athletes athlete = athleteService.getAthlete(userId);
        return ResponseEntity.ok(athlete);
    }

    // 3. Get Athlete by ID
    @GetMapping("/{athleteId}")
    public ResponseEntity<Athletes> getAthleteById(@PathVariable int athleteId) {
        Athletes athlete = athleteService.getAthleteById(athleteId);
        return ResponseEntity.ok(athlete);
    }

    // 4. Get All Athletes
    @GetMapping
    public ResponseEntity<List<Athletes>> getAll() {
        List<Athletes> athletes = athleteService.getAll();
        return ResponseEntity.ok(athletes);
    }

    @GetMapping("/findByUserId/{userId}")
    public Athletes findAthleteByUserId(@PathVariable int userId){
        return athleteService.findAthleteByUserId(userId);
    }

    @GetMapping("/findIdByUserId/{userId}")
    public int findAthleteIdByUserId(@PathVariable int userId){
        return athleteService.findAthleteIdByUserId(userId);
    }
}
