package com.prakritidev.verma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prakritidev.verma.service.FileInputService;
import com.prakritidev.verma.service.TerminalInputService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
    private FileInputService fileInputService;

    @Autowired
    private TerminalInputService terminalInputService;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length > 0) {
            switch (args[0]) {
                case "rest" -> {
                        }
                case "file" -> {
                    if (args.length > 1) {
                        String input = fileInputService.readFileInput(args[1]);
                        System.out.println("File input: " + input);
                    } else {
                        System.err.println("File path not provided");
                    }   }
                case "terminal" -> {
                    String input = terminalInputService.readTerminalInput();
                    System.out.println("Terminal input: " + input);
                        }
                default -> System.err.println("Unknown input method: " + args[0]);
            }
        } else {
            System.err.println("No input method provided");
        }
	}

}
