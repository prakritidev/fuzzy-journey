package com.prakritidev.verma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;


class DataStructureControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        System.out.println("Starting Dynamic Programming Controller Level Unit tests");

    }

    @AfterEach
    void tearDown() {
        System.out.println("Done with Dynamic Programming Controller Level Unit tests");
    }

    @Test
    void test200OKForKnapSackProblems() {

    }
}