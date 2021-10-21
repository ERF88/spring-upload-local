package com.example.upload.controller;

import com.example.upload.service.FileStorageService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/upload")
public class UploadController {

    private final FileStorageService service;

    @PostMapping
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {

        try {
            service.saveFile(file);
            return ResponseEntity.status(HttpStatus.OK).body("Upload success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed");
        }
    }
}
