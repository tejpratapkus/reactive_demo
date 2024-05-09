package com.demo.reactive.controller;

import com.demo.reactive.entity.Student;
import com.demo.reactive.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Mono<Student> save(@RequestBody Student student) {
        return service.save(student);
    }

    @GetMapping
    public Flux<Student> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Student> findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping("/{firstName}")
    public Flux<Student> findByFirstName(@PathVariable String firstName) {
        return service.findByFirstName(firstName);
    }

}
