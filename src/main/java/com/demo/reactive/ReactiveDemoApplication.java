package com.demo.reactive;

import com.demo.reactive.entity.Student;
import com.demo.reactive.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentService service) {
        return args -> {
            for (int i = 0; i < 50; i++) {
                service.save(Student.builder()
                        .firstName("Tej-" + i)
                        .lastName("Pratap-" + i)
                        .age(i)
                        .build()).subscribe();
            }
        };
    }

}
