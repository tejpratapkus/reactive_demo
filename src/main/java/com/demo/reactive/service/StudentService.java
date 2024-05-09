package com.demo.reactive.service;

import com.demo.reactive.entity.Student;
import com.demo.reactive.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Mono<Student> save(Student student) {
        return repository.save(student);
    }

    public Flux<Student> findAll() {
        return repository.findAll()
                .delayElements(Duration.ofSeconds(1));
    }

    public Mono<Student> findById(Integer id) {
        return repository.findById(id);
    }

    public Flux<Student> findByFirstName(String firstName) {
        return repository.findAllByFirstNameIgnoreCase(firstName);
    }


}
