package com.example.practise.demo.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepo studentRepo) {
        return args -> {
            Student tejal = new Student("Tejal", "test@gmail.com",
                    LocalDate.of(1998, 11, 24));

            Student srujal = new Student ("Srujal", "test1@gmail.com",
                     LocalDate.of(1995, 11, 24));
            List<Student> list = studentRepo.saveAll(Arrays.asList(srujal, tejal));
            System.out.println(list);
        };
    }
}

