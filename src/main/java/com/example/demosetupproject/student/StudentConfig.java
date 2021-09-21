//package com.example.demosetupproject.student;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class StudentConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner (StudentRepository repository) {
//        return args -> {
//            Student mariam = new Student(
//                    "Mariam",
//                    "mariam@hotmail.com",
//                    LocalDate.of(1996, Month.JULY, 1)
//            );
//
//            Student alex = new Student(
//                    "Alex",
//                    "alex@hotmail.com",
//                    LocalDate.of(2004, Month.JULY, 1)
//            );
//
//            repository.saveAll(
//                    List.of(mariam, alex)
//            );
//        };
//    }
//}
