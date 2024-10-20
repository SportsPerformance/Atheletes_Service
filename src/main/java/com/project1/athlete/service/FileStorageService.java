package com.project1.athlete.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public String storeFile(MultipartFile file, int athleteId) throws IOException {
        // Create athlete-specific directory if it does not exist
        String athleteDir = uploadDir + "/athlete_" + athleteId;
        Path athletePath = Paths.get(athleteDir);
        if (!Files.exists(athletePath)) {
            Files.createDirectories(athletePath);
        }

        // Build the file path
        String fileName = file.getOriginalFilename();
        String filePath = athleteDir + "/" + fileName;

        // Save the file on the server
        file.transferTo(new File(filePath));

        // Return relative file path (can be stored in database)
        return "/uploads/athlete_" + athleteId + "/" + fileName;
    }
}
