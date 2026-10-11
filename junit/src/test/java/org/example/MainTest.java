package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
private Main main = new Main();
    @Test
    void add() {

        int result = main.add(3,4);
        int expectedResult = 7;
        assertEquals(expectedResult,result);

    }

    //@BeforeEach -> it will run before the @Test annotated method, set up before each test
    //@AfterEach -> it will run after the @Test annotated method, clean up after each test
    //@BeforeAll -> setup for all tests
    //@AfterAll -> cleanup for all test
}