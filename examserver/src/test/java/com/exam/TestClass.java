package com.exam;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;


@SpringBootTest
public class TestClass {

    @Test
    public void testDates(){
        System.out.println("Starting test");
        LocalDate today = LocalDate.now();
        LocalDate dob = LocalDate.of(1994, 11, 20);

        System.out.println(today);
        System.out.println(dob.getDayOfWeek());


    }
}
