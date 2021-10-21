package com.example.upload.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {
    
    public void initializeDir() {
        try {
            Files.createDirectory(Paths.get("uploads"));
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void saveFile(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), Paths.get("uploads").resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
