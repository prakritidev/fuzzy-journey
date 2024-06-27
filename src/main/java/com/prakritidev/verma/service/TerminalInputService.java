package com.prakritidev.verma.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class TerminalInputService {

    public String readTerminalInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your input:");
            return scanner.nextLine();
        }
    }
}