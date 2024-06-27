package com.prakritidev.verma.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileInputService {

    public String readFileInput(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}